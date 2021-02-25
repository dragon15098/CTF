package com.myjavablog.controller;

import com.alibaba.fastjson.JSON;
import com.myjavablog.model.Role;
import com.myjavablog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Checker {
    @Autowired
    private DataSource dataSource;
    @Autowired
    Environment env;

    private boolean isOke;
    private Map message;

    public Map getMessage() {
        return message;
    }

    public void setMessage(Map message) {
        this.message = message;
    }

    public boolean isOke() {
        return isOke;
    }

    public Checker() {
        this.isOke = checkConnection();
    }

    public boolean checkConnection() {
        //  Custom checking for sure
        String testQuery = env.getProperty("spring.datasource.hikari.connection-test-query");
        if (testQuery != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                try (Statement statement = connection.createStatement()) {
                    statement.execute(testQuery);
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.message = Collections.singletonMap("message", e.getMessage());
                return false;
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.message = Collections.singletonMap("message", "Database Oke with query: " + testQuery);
            return true;
        } else {
            this.message = Collections.singletonMap("message", "spring.datasource.hikari.connection-test-query is missing");
            return false;
        }
    }

    private boolean checkRole(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("USER_DETAIL")) {
                String value = new String(Base64.getDecoder().decode(cookie.getValue()));
                User user = JSON.parseObject(value, User.class);
                Set<Role> roles = user.getRoles();
                if (roles != null) {
                    for (Role role : roles) {
                        if (role.getRole().equals("ADMIN")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
