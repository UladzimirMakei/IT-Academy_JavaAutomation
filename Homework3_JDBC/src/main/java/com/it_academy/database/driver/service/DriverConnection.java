package com.it_academy.database.driver.service;

import java.sql.SQLException;
import java.sql.Statement;

public class DriverConnection {
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";

    public static boolean isJDBCDriverRegistered() {
        boolean result = true;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " JDBC driver not found");
            result = false;
        }
        return result;
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
}