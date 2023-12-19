package com.hexaware.dao;

import com.hexaware.entity.User;

/**
 * Interface defining operations for managing users in a data access layer.
 */
public interface UserDao {

    /**
     * Validates a user's credentials.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return         The User object if validated successfully, otherwise null.
     */
    User validateUser(String username, String password);

    /**
     * Adds a new user to the system.
     *
     * @param user The User object to be added.
     */
    void addUser(User user);
}
