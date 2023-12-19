package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to fetch database properties from the configuration file.
 */
public class DBPropertyUtil {
	
	/**
     * Retrieves the database connection string from the properties file.
     *
     * @return The database connection string based on the properties file.
     */
    public static String getPropertyString() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
            String hostname = prop.getProperty("hostname");
            String dbname = prop.getProperty("dbname");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String port = prop.getProperty("port");
            
            return "jdbc:mysql://" + hostname + ":" + port + "/" + dbname +
                   "?user=" + username + "&password=" + password + "&useSSL=false";
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
