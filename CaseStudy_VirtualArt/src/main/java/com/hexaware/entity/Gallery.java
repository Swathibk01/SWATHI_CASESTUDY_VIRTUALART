package com.hexaware.entity;

/**
 * Represents a Gallery entity containing information about an art gallery.
 */
public class Gallery {
    private int galleryId;       // Unique ID of the gallery
    private String name;         // Name of the gallery
    private String description;  // Description of the gallery
    private String location;     // Location of the gallery
    private Artist curator;      // Reference to an Artist object representing the curator
    private String openingHours; // Opening hours of the gallery

    /**
     * Retrieves the unique ID of the gallery.
     *
     * @return The gallery's ID.
     */
    public int getgalleryId() {
        return galleryId;
    }

    /**
     * Sets the unique ID of the gallery.
     *
     * @param galleryId The gallery's ID to be set.
     */
    public void setgalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    /**
     * Retrieves the Name of the gallery.
     *
     * @return The gallery's Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the gallery.
     *
     * @param name The gallery's Name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the Description of the gallery.
     *
     * @return The gallery's Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description of the gallery.
     *
     * @param description The gallery's Description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the Location of the gallery.
     *
     * @return The gallery's Location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the Location of the gallery.
     *
     * @param location The gallery's Location to be set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retrieves the Curator of the gallery.
     *
     * @return The gallery's Curator.
     */
    public Artist getCurator() {
        return curator;
    }

    /**
     * Sets the Curator of the gallery.
     *
     * @param curator The gallery's Curator to be set.
     */
    public void setCurator(Artist curator) {
        this.curator = curator;
    }

    /**
     * Retrieves the OpeningHours of the gallery.
     *
     * @return The gallery's OpeningHours.
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets the OpeningHours of the gallery.
     *
     * @param openingHours The gallery's OpeningHours to be set.
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Provides a string representation of the Gallery object.
     *
     * @return A string containing gallery details: ID, name, description, location, curator, and opening hours.
     */
    @Override
    public String toString() {
        return "Gallery [galleryId=" + galleryId + ", name=" + name + ", description=" + description
                + ", location=" + location + ", curator=" + curator + ", openingHours=" + openingHours + "]";
    }
}
