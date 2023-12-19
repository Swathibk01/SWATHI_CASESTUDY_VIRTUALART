package com.hexaware.dao;

import com.hexaware.entity.User;
import com.hexaware.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface defining operations for managing users in a data access layer.
 */
public class UserDaoImpl implements UserDao {
	private final Connection conn = DBConnection.getConnection();
    
    /**
     * Validates a user's credentials.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return         The User object if validated successfully, otherwise null.
     */
    @Override
    public User validateUser(String username, String password) {
        User user = null;
        try {
            String sql = "SELECT * FROM User WHERE Username = ? AND Password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Adds a new user to the system.
     *
     * @param user The User object to be added.
     */
    @Override
    public void addUser(User user) {
    	try {
    	    // Execute SQL Insert Query
    	    String sql = "INSERT INTO user ( UserID ,Username, Password, Email) VALUES (?, ?, ?, ?)";
    	    PreparedStatement stmt = conn.prepareStatement(sql);
    	    stmt.setInt(1, user.getUserId());
    	    stmt.setString(2, user.getUsername());
    	    stmt.setString(3, user.getPassword());
    	    stmt.setString(4, user.getEmail());
    	    int rowsInserted = stmt.executeUpdate();
    	    if (rowsInserted > 0) {
    	        System.out.println("User inserted successfully.");
    	    } else {
    	        System.out.println("Failed to insert user.");
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}

    }
}
