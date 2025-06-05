package com.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for obtaining JDBC connections using values from
 * {@link ConfigReader}.
 */
public class DatabaseConnector {
    private static Connection connection;

    /**
     * Returns a singleton JDBC connection. Connection details are read from
     * <code>browser.properties</code> using keys <code>db.url</code>,
     * <code>db.username</code> and <code>db.password</code>.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = ConfigReader.getProperty("db.url");
            String user = ConfigReader.getProperty("db.username");
            String pass = ConfigReader.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }

    /**
     * Closes the underlying JDBC connection if it exists.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
