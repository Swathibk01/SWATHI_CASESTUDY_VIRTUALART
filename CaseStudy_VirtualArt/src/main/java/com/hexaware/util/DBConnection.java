package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Handles the database connection for the application.
 */
public class DBConnection {
    private static Connection connection = null;

    /**
     * Retrieves the database connection.
     *
     * @return The Connection object for the database.
     */
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            String connectionString = DBPropertyUtil.getPropertyString();
            if (connectionString != null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(connectionString);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }
    }
}
