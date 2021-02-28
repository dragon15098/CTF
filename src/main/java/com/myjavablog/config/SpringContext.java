package com.myjavablog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SpringContext {
    private static Environment environment;
    private static DataSource dataSource;

    public SpringContext(Environment environment, DataSource dataSource) {
        SpringContext.environment = environment;
        SpringContext.dataSource = dataSource;
    }

    public static Environment getEnvironment() {
        if (environment == null) {
            throw new RuntimeException("Environment has not been set yet");
        }
        return environment;
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            throw new RuntimeException("Data source has not been set yet");
        }
        return dataSource;
    }


}
