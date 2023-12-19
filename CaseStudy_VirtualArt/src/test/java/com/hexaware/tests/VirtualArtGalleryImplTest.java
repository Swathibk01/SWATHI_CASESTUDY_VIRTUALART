package com.hexaware.tests;
import com.hexaware.dao.VirtualArtGalleryImpl;
import com.hexaware.entity.Artwork;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for VirtualArtGalleryImpl methods.
 */
public class VirtualArtGalleryImplTest {

	/**
     * Tests the addition of an artwork.
     */
    @Test
    public void testAddArtwork() {
    	VirtualArtGalleryImpl artworkDAO = new VirtualArtGalleryImpl();
        Artwork artwork = new Artwork();
        artwork.setartworkId(117); 
        artwork.setTitle("Artwork 123");
        artwork.setDescription("number art");
        artwork.setimageUrl("number.jpg");
        assertTrue(artworkDAO.addArtwork(artwork));
    }

    /**
     * Tests the update of an artwork.
     */
    @Test
    public void testUpdateArtwork() {
    	VirtualArtGalleryImpl artworkDAO = new VirtualArtGalleryImpl();
        Artwork artwork = new Artwork();
        artwork.setartworkId(109);
        artwork.setTitle("swathi art");
        artwork.setDescription("Art of her");
        artwork.setMedium("stone painting");
        artwork.setimageUrl("paint.jpg");
        assertTrue(artworkDAO.updateArtwork(artwork));
    }
    
    /**
     * Tests the removal of an artwork.
     */
    @Test
        public void testRemoveArtwork() {
        VirtualArtGalleryImpl artworkDAO = new VirtualArtGalleryImpl();
        int artworkIdToRemove = 110;         
        assertTrue(artworkDAO.removeArtwork(artworkIdToRemove));
    
    }
    
    /**
     * Tests the get an artwork using Id.
     */
    @Test
    public void testGetArtworkById() {
       
        int artworkId = 102; 
        VirtualArtGalleryImpl artworkDAO = new VirtualArtGalleryImpl();
        Artwork retrievedArtwork = artworkDAO.getArtworkById(artworkId);
        assertNotNull(retrievedArtwork);
    }

    /**
     * Tests search an artwork by keyword.
     */
    @Test
    public void testSearchArtworks() {
    	
        // Provide a keyword for searching artworks and validate the results
        //keyword Title or Description of Gallery
        String keyword = "lastest one"; // Replace with a search keyword
        VirtualArtGalleryImpl artworkDAO = new VirtualArtGalleryImpl();
        assertNotNull(artworkDAO.searchArtworks(keyword));
    }
}
