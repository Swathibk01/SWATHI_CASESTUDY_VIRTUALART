package com.hexaware.entity;

import java.sql.Date;

/**
 * Represents an artist in the art gallery.
 */
public class Artwork {
	private int artworkId;
	private String title;
    private String description;
    private Date creationDate;
    private String medium;
    private String imageUrl;
    
    /**
     * Retrieves the unique ID of the artist.
     *
     * @return The artist's ID.
     */
	public int getartworkId() {
		return artworkId;
	}
	
	/**
     * Sets the unique ID of the artwork.
     *
     * @param artworkId The artwork's ID to be set.
     */
	public void setartworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	
	/**
     * Retrieves the Title of the artwork.
     *
     * @return The artwork's Title.
     */
	public String getTitle() {
		return title;
	}
	
	/**
     * Sets the Title of the artwork.
     *
     * @param title The artwork's Title to be set.
     */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
     * Retrieves the Description of the artwork.
     *
     * @return The artwork's Description.
     */
	public String getDescription() {
		return description;
	}
	
	/**
     * Sets the Description of the artwork.
     *
     * @param description The artwork's Description to be set.
     */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
     * Retrieves the CreationDate of the artwork.
     *
     * @return The artist's CreationDate.
     */
	public Date getCreationDate() {
		return creationDate;
	}
	
	/**
     * Sets the CreationDate of the artwork.
     *
     * @param creationDate The artwork's CreationDate to be set.
     */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
     * Retrieves the Medium of the artwork.
     *
     * @return The artwork's Medium.
     */
	public String getMedium() {
		return medium;
	}
	
	/**
     * Sets the Medium of the artwork.
     *
     * @param medium The artwork's Medium to be set.
     */
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	/**
     * Retrieves the imageUrl of the artwork.
     *
     * @return The artist's imageUrl.
     */
	public String getimageUrl() {
		return imageUrl;
	}
	
	/**
     * Sets the imageUrl of the artwork.
     *
     * @param imageUrl The artwork's imageUrl to be set.
     */
	public void setimageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/**
     * Provides a string representation of the Artwork object.
     *
     * @return string containing artwork details:ID, title, description, creationDate, medium,imageURL.
     */
	@Override
	public String toString() {
		return "Artwork [artworkId=" + artworkId + ", title=" + title + ", description=" + description
				+ ", creationDate=" + creationDate + ", medium=" + medium + ", imageUrl=" + imageUrl + "]";
	}
}
 