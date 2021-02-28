package com.myjavablog.controller;

import com.myjavablog.config.SpringContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Collections;
import java.util.Map;

public class Checker {

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
        isOke = checkConnection();
    }

    public boolean checkConnection() {
        //  Custom checking for sure
        Environment environment = SpringContext.getEnvironment();
        if (environment == null) {
            return false;
        }
        String testQuery = environment.getProperty("spring.datasource.hikari.connection-test-query");
        if (testQuery != null) {
            Connection connection = null;
            try {
                connection = SpringContext.getDataSource().getConnection();
                try (Statement statement = connection.createStatement()) {
                    statement.execute(testQuery);
                }
            } catch (Exception e) {
                this.message = Collections.singletonMap("message", e.getMessage());
                return false;
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignored) {
                    }
                }
            }
            this.message = Collections.singletonMap("message", "Database Oke with query: " + testQuery);
            return true;
        } else {
            this.message = Collections.singletonMap("message", "spring.datasource.hikari.connection-super_secret_src_zzzzzzzz.zip-query is missing");
            return false;
        }
    }
}
