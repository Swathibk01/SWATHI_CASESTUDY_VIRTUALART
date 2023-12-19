package com.hexaware.controller;

import com.hexaware.dao.UserDao;
import com.hexaware.dao.UserDaoImpl;
import com.hexaware.entity.User;
import java.util.Scanner;

/**
 * Controller class for managing User operations.
 */
public class UserController {
    private final UserDao userDAO;
    
    /**
     * Constructor initializing UserController with UserDAO.
     */
    public UserController() {
        this.userDAO = new UserDaoImpl(); 
    }
    
    /**
     * Validates user credentials.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return         The User object if validated successfully, otherwise null.
     */
    public User validateUser(String username, String password) {
    	return userDAO.validateUser(username, password);
    	} 
    
    /**
     * Gets user details from the console input.
     *
     * @param scanner The Scanner object for user input.
     * @return        The User object with details entered by the user.
     */
    public User getUserDetails(Scanner scanner) {
    	System.out.println("Enter UserID:");
	    int userID = scanner.nextInt();
	    
		System.out.println("Enter Username:");
	    String username = scanner.next();
	
	    System.out.println("Enter Password:");
	    String password = scanner.next();
	
	    System.out.println("Enter Email:");
	    String email = scanner.next();
	    
	    User newUser = new User();
	    newUser.setUserId(userID);
	    newUser.setUsername(username);
	    newUser.setPassword(password);
	    newUser.setEmail(email);
	    return newUser;
    }
    
    /**
     * Registers a new user.
     *
     * @param user The User object to be registered.
     */
    public void registerUser(User user) {
    	userDAO.addUser(user);
    	}
}
