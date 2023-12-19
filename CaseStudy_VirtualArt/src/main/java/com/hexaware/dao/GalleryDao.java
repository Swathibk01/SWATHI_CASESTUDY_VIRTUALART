package com.hexaware.dao;

import com.hexaware.entity.Gallery;
import java.util.List;
/**
 * Interface defining operations for managing Galleries.
 */
public interface GalleryDao {

    /**
     * Adds a new Gallery to the system.
     *
     * @param gallery The Gallery object to be added.
     * @return        True if the addition is successful, otherwise false.
     */
    boolean addGallery(Gallery gallery);
    
    /**
     * Updates an existing Gallery in the system.
     *
     * @param gallery The Gallery object to be updated.
     * @return        True if the update is successful, otherwise false.
     */
    boolean updateGallery(Gallery gallery);

    /**
     * Removes a Gallery from the system by its ID.
     *
     * @param galleryId The ID of the Gallery to be removed.
     * @return          True if the removal is successful, otherwise false.
     */
    boolean removeGallery(int galleryId);
    
    /**
     * Searches for Galleries based on a keyword.
     *
     * @param keyword The keyword to search for in Gallery names or descriptions.
     * @return        List of Galleries matching the keyword.
     */
    List<Gallery> searchGalleries(String keyword);
}
