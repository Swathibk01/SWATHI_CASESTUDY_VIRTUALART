package com.hexaware.entity;

import java.sql.Date;
import java.util.List;

/**
 * Represents a user in the art system.
 */
public class User {
    private int userId;                 // Unique ID of the user
    private String username;            // Username of the user
    private String password;            // Password of the user
    private String email;               // Email address of the user
    private String firstName;           // First name of the user
    private String lastName;            // Last name of the user
    private Date dateOfBirth;           // Date of birth of the user
    private String profilePicture;      // URL of the user's profile picture
    private List<Artwork> favoriteArtworks; // List of artworks marked as favorites by the user

    /**
     * Retrieves the unique ID of the user.
     *
     * @return The user's ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique ID of the user.
     *
     * @param userId The user's ID to be set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The user's username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The user's password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The user's email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The user's first name to be set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The user's last name to be set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the date of birth of the user.
     *
     * @return The user's date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the user.
     *
     * @param dateOfBirth The user's date of birth to be set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the profile picture URL of the user.
     *
     * @return The user's profile picture URL.
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets the profile picture URL of the user.
     *
     * @param profilePicture The user's profile picture URL to be set.
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Retrieves the list of favorite artworks of the user.
     *
     * @return The user's favorite artworks.
     */
    public List<Artwork> getFavoriteArtworks() {
        return favoriteArtworks;
    }

    /**
     * Sets the list of favorite artworks of the user.
     *
     * @param favoriteArtworks The user's favorite artworks to be set.
     */
    public void setFavoriteArtworks(List<Artwork> favoriteArtworks) {
        this.favoriteArtworks = favoriteArtworks;
    }

    /**
     * Provides a string representation of the User object.
     *
     * @return A string containing user details: ID, username, password, email, first and last name,
     *         date of birth, profile picture URL, and favorite artworks.
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
                + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
                + ", profilePicture=" + profilePicture + ", favoriteArtworks=" + favoriteArtworks + "]";
    }
}
