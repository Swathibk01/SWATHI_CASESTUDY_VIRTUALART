package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import java.util.List;

/**
 * Interface defining operations for managing Artworks and User Favorites in a Virtual Art Gallery.
 */
public interface IvirtualArtGallery {

    /**
     * Adds an Artwork to the Virtual Art Gallery.
     *
     * @param artwork The Artwork object to be added.
     * @return        True if addition is successful, otherwise false.
     */	
    boolean addArtwork(Artwork artwork);

    /**
     * Updates an existing Artwork in the Virtual Art Gallery.
     *
     * @param artwork The Artwork object with updated details.
     * @return        True if update is successful, otherwise false.
     */
    boolean updateArtwork(Artwork artwork);

    /**
     * Removes an Artwork from the Virtual Art Gallery by its ID.
     *
     * @param artworkID The ID of the Artwork to be removed.
     * @return          True if removal is successful, otherwise false.
     */
    boolean removeArtwork(int artworkID);

    /**
     * Retrieves an Artwork from the Virtual Art Gallery by its ID.
     *
     * @param artworkID The ID of the Artwork to retrieve.
     * @return          The Artwork object if found, otherwise null.
     */
    Artwork getArtworkById(int artworkID);

    /**
     * Searches for Artworks in the Virtual Art Gallery based on a keyword.
     *
     * @param keyword The keyword to search for in Artwork titles or descriptions.
     * @return        List of Artworks matching the keyword.
     */
    List<Artwork> searchArtworks(String keyword);

    /**
     * Adds an Artwork to a user's favorites in the Virtual Art Gallery.
     *
     * @param userId    The ID of the user.
     * @param artworkId The ID of the Artwork to add to favorites.
     * @return          True if addition to favorites is successful, otherwise false.
     */
    boolean addArtworkToFavorite(int userId, int artworkId);

    /**
     * Removes an Artwork from a user's favorites in the Virtual Art Gallery.
     *
     * @param userId    The ID of the user.
     * @param artworkId The ID of the Artwork to remove from favorites.
     * @return          True if removal from favorites is successful, otherwise false.
     */
    boolean removeArtworkFromFavorite(int userId, int artworkId);

    /**
     * Retrieves Artworks marked as favorites by a user in the Virtual Art Gallery.
     *
     * @param userId The ID of the user.
     * @return       List of Artworks marked as favorites by the user.
     */
    List<Artwork> getUserFavoriteArtworks(int userId);
}
