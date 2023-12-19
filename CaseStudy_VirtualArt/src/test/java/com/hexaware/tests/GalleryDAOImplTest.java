package com.hexaware.tests;
import com.hexaware.dao.GalleryDaoImpl;
import com.hexaware.entity.Gallery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for the GalleryDaoImpl methods.
 */
public class GalleryDAOImplTest {

	/**
     * Tests the addition of a gallery.
     */
	@Test
    public void testAddGallery() {
        GalleryDaoImpl galleryDAO = new GalleryDaoImpl();
        Gallery gallery = new Gallery();
        gallery.setgalleryId(412);
        gallery.setName(" Gallery of flowers");
        gallery.setDescription("Latest gallery idea");
        gallery.setLocation("bangalore");
        assertTrue(galleryDAO.addGallery(gallery));
    } 

	/**
     * Tests the update of a gallery.
     */
	@Test
    public void testUpdateGallery() {
        GalleryDaoImpl galleryDAO = new GalleryDaoImpl();
        Gallery gallery = new Gallery();
        gallery.setgalleryId(403);
        gallery.setName("hexaware gallery");
        gallery.setDescription("gall of hexa");
        gallery.setLocation("chennai");
        gallery.setOpeningHours("5PM ");
        assertTrue(galleryDAO.updateGallery(gallery));
    }

	/**
     * Tests the removal of a gallery.
     */
    @Test
    public void testRemoveGallery() {
        GalleryDaoImpl galleryDAO = new GalleryDaoImpl();
        int galleryId = 410; 
        assertTrue(galleryDAO.removeGallery(galleryId));
    }

    /**
     * Tests the search functionality for galleries.
     */
    @Test
    public void testSearchGalleries() {
        GalleryDaoImpl galleryDAO = new GalleryDaoImpl();
        //keyword Name or Description of Gallery
        String keyword = "Tate Britain";
        List<Gallery> galleries = galleryDAO.searchGalleries(keyword);
        assertFalse(galleries.isEmpty());
    }
}
