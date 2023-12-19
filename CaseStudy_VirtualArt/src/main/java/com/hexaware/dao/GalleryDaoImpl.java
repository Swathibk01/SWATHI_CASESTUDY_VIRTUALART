package com.hexaware.dao;

import com.hexaware.entity.Gallery;
import com.hexaware.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Gallery DAO for database operations related to galleries.
 *
 */

public class GalleryDaoImpl implements GalleryDao {
	private final Connection conn = DBConnection.getConnection();

    /**
     * Adds a new gallery to the database.
     *
     * @param gallery The Gallery object to be added.
     * @return        True if addition is successful, otherwise false.
     */
    
    @Override
    public boolean addGallery(Gallery gallery) {
    	// Implementation to add a gallery to the database
    	try {
            String sql = "INSERT INTO Gallery (GalleryID, Name, Description, Location) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, gallery.getgalleryId());
            stmt.setString(2, gallery.getName());
            stmt.setString(3, gallery.getDescription());
            stmt.setString(4, gallery.getLocation());
            
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing gallery in the database.
     *
     * @param gallery The Gallery object with updated details.
     * @return        True if update is successful, otherwise false.
     */
    
    @Override
    public boolean updateGallery(Gallery gallery) {
    	 // Implementation to update a gallery in the database
    	try {
            String sql = "UPDATE Gallery SET Name = ?, Description = ?, Location = ?, OpeningHours = ? " +
                    "WHERE GalleryID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gallery.getName());
            stmt.setString(2, gallery.getDescription());
            stmt.setString(3, gallery.getLocation());
            stmt.setString(4, gallery.getOpeningHours());
            stmt.setInt(5, gallery.getgalleryId());
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    /**
     * Removes a gallery from the database by its ID.
     *
     * @param galleryId The ID of the gallery to be removed.
     * @return          True if removal is successful, otherwise false.
     */
    
    @Override
    public boolean removeGallery(int galleryId) {
    	// Implementation to remove a gallery from the database
    	try {
            String sql = "DELETE FROM Gallery WHERE GalleryID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, galleryId);
            
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Searches for galleries based on a keyword in name or description.
     *
     * @param keyword The keyword to search for in gallery names or descriptions.
     * @return        List of galleries matching the keyword.
     */

    @Override
    public List<Gallery> searchGalleries(String keyword) {
    	// Implementation to search galleries in the database based on a keyword
    	 List<Gallery> galleries = new ArrayList<>();
    	    try {
    	        String sql = "SELECT * FROM Gallery WHERE Name LIKE ? OR Description LIKE ?";
    	        PreparedStatement stmt = conn.prepareStatement(sql);
    	        stmt.setString(1, "%" + keyword + "%");
    	        stmt.setString(2, "%" + keyword + "%");
    	        ResultSet rs = stmt.executeQuery();
    	        while (rs.next()) {
    	            Gallery gallery = new Gallery();
    	            gallery.setgalleryId(rs.getInt("GalleryID"));
    	            gallery.setName(rs.getString("Name"));
    	            gallery.setDescription(rs.getString("Description"));
    	            gallery.setLocation(rs.getString("Location"));
    	            gallery.setOpeningHours(rs.getString("OpeningHours"));
    	            galleries.add(gallery);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return galleries;

    }
}
