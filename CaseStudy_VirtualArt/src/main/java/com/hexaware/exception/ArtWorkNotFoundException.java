package com.hexaware.exception;

/**
 * Represents an exception thrown when an artwork is not found.
 * Extends the Exception class to create a custom exception for artwork-related errors.
 */
public class ArtWorkNotFoundException extends Exception {
	
	/**
     * Constructs an ArtWorkNotFoundException with a specified error message.
     *
     * @param message A String containing details about the exception.
     */
	public ArtWorkNotFoundException(String message) {
		super(message);
    }
}