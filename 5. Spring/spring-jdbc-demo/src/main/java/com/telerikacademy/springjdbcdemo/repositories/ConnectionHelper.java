package com.telerikacademy.springjdbcdemo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@PropertySource("classpath:application.properties")
public class ConnectionHelper {
    private String dbUrl, username, password;

    @Autowired
    public ConnectionHelper(Environment env) {
        dbUrl = env.getProperty("database.url");
        username = env.getProperty("database.username");
        password = env.getProperty("database.password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }
}
