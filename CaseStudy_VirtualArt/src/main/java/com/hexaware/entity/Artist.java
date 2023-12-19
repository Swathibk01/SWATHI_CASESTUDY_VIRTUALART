package com.hexaware.entity;

import java.sql.Date;

/**
 * Represents an artist in the art gallery.
 */
public class Artist {
	private int artistId;
    private String name;
    private String biography;
    private Date birthDate;
    private String nationality;
    private String website;
    private String contactInformation;
    
    /**
     * Retrieves the unique ID of the artist.
     *
     * @return The artist's Id.
     */
	public int getartistId() {
		return artistId;
	}
	
    /**
     * Sets the unique ID of the artist.
     *
     * @param artistId The artist's ID to be set.
     */

	public void setartistId(int artistId) {
		this.artistId = artistId;
	}
	
	/**
     * Retrieves the name of the artist.
     *
     * @return The name of the artist.
     */
	public String getName() {
		return name;
	}
	
	/**
     * Sets the name of the artist.
     *
     * @param name The name of the artist to be set.
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Retrieves the Biography of the artist.
     *
     * @return The Biography.
     */
	public String getBiography() {
		return biography;
	}
	
	/**
     * Sets the Biography of the artist.
     *
     * @param biography The Biography of the artist to be set.
     */
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	/**
     * Retrieves the BirthDate of the artist.
     *
     * @return The BirthDate.
     */
	public Date getBirthDate() {
		return birthDate;
	}
	
	/**
     * Sets the BirthDate of the artist.
     *
     * @param birthDate The BirthDate of the artist to be set.
     */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
     * Retrieves the Nationality of the artist.
     *
     * @return The Nationality.
     */
	public String getNationality() {
		return nationality;
	}
	
	/**
     * Sets the Nationality of the artist.
     *
     * @param nationality The Nationality of the artist to be set.
     */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}	
	
	/**
     * Retrieves the Website of the artist.
     *
     * @return The Website.
     */
	public String getWebsite() {
		return website;
	}
	
	/**
     * Sets the Website of the artist.
     *
     * @param website The Website of the artist to be set.
     */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	/**
     * Retrieves the ContactInformation of the artist.
     *
     * @return The ContactInformation.
     */
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
     * Sets the ContactInformation.
     *
     * @param  contactInformation of the artist to be set.
     */
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	
	/**
     * Provides a string representation of the Artist object.
     *
     * @return A string containing artist details: ID, name, biography, birthDate, nationality, Website, and contact information.
     */
	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", name=" + name + ", biography=" + biography + ", birthDate="
				+ birthDate + ", nationality=" + nationality + ", website=" + website + ", contactInformation="
				+ contactInformation + "]";
	}
}
