package com.hexaware.exception;

/**
 * Represents an exception thrown when a user is not found.
 * Extends the Exception class to create a custom exception for user-related errors.
 */
public class UserNotFoundException extends Exception {
	
	/**
     * Constructs a UserNotFoundException with a specified error message.
     *
     * @param message A String containing details about the exception.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}