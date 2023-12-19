package com.hexaware.dao;

import com.hexaware.entity.Artwork;
import com.hexaware.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of IVirtualArtGallery for database operations related to artwork.
 */
public class VirtualArtGalleryImpl implements IvirtualArtGallery {
	private Connection conn;
	
	/**
     * Constructor initializing the database connection.
     */
    public VirtualArtGalleryImpl() {
        conn = DBConnection.getConnection(); 
    }
    
    /**
     * Adds a new Artwork to the database.
     *
     * @param artwork The Artwork object to be added.
     * @return True if the addition is successful, otherwise false.
     */
	@Override
 public boolean addArtwork(Artwork artwork) {
		String sql = "INSERT INTO Artwork (ArtworkID , Title, Description,CreationDate,Medium, ImageURL) " + "VALUES (?,?,?, ?, ?, ?)";
                
   try {
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setInt(1, artwork.getartworkId());
       stmt.setString(2, artwork.getTitle()); 
       stmt.setString(3, artwork.getDescription());
       stmt.setDate(4,artwork.getCreationDate());
       stmt.setString(5,artwork.getMedium());
       stmt.setString(6, artwork.getimageUrl());
       int rowsInserted = stmt.executeUpdate(); 
       return rowsInserted > 0;
   } catch (SQLException e) {
       e.printStackTrace();
   }
   
     return false; // Placeholder, implement your logic here
 }

	/**
     * Updates an existing Artwork in the database.
     *
     * @param artwork The Artwork object to be updated.
     * @return True if the update is successful, otherwise false.
     */
 @Override
 public boolean updateArtwork(Artwork artwork) {
	 String sql = "UPDATE Artwork SET Title = ?, Description = ?, CreationDate=?,Medium=?,ImageURL = ? WHERE ArtworkID = ?";
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, artwork.getTitle());
	        stmt.setString(2, artwork.getDescription());
	        stmt.setDate(3, artwork.getCreationDate());
	        stmt.setString(4, artwork.getMedium());
	        stmt.setString(5, artwork.getimageUrl()); 
	        stmt.setInt(6, artwork.getartworkId());

	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	   
	    return false;
	}
 
 /**
  * Removes an Artwork from the database by its ID.
  *
  * @param artworkId The ID of the Artwork to be removed.
  * @return True if the removal is successful, otherwise false.
  */
	

 @Override
 public boolean removeArtwork(int artworkId) {
	 try{
		 String sql= "DELETE FROM artwork_gallery WHERE ArtworkID = ?";
     PreparedStatement Stmt = conn.prepareStatement(sql);
     Stmt.setInt(1, artworkId);
     Stmt.executeUpdate();
     
     //delete the artwork from the artwork table
     String deleteArtworkQuery = "DELETE FROM artwork WHERE ArtworkID = ?";
     PreparedStatement deleteArtworkStmt = conn.prepareStatement(deleteArtworkQuery);
     deleteArtworkStmt.setInt(1, artworkId);
     int rowsAffected = deleteArtworkStmt.executeUpdate();
     
     return rowsAffected > 0; // Return true if deletion w
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
     return false; 
 }
 
 /**
  * Searches for Artworks based on a keyword in title or description.
  *
  * @param keyword The keyword to search for in Artwork titles or descriptions.
  * @return List of Artworks matching the keyword.
  */
 @Override
 public List<Artwork> searchArtworks(String keyword) {
	 List<Artwork> artworks = new ArrayList<>(); 
	    
	    String sql = "SELECT * FROM artwork WHERE Title LIKE ? OR Description LIKE ?";
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, "%" + keyword + "%"); 
	        stmt.setString(2, "%" + keyword + "%");
	        
	        ResultSet rs = stmt.executeQuery(); 
	        
	        while (rs.next()) {
	            Artwork art = new Artwork();
	            art.setartworkId(rs.getInt("ArtworkID"));
	            art.setTitle(rs.getString("Title"));
	            art.setDescription(rs.getString("Description"));
	            art.setimageUrl(rs.getString("ImageURL"));
	            art.setMedium(rs.getString("Medium"));
	            art.setCreationDate(rs.getDate("CreationDate"));
	            
	            artworks.add(art);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return artworks;  
	} 

 /**
  * Adds an Artwork to a user's favorites.
  *
  * @param userId    The ID of the user.
  * @param artworkId The ID of the Artwork to be added to favorites.
  * @return True if addition to favorites is successful, otherwise false.
  */
 @Override
 public boolean addArtworkToFavorite(int userId, int artworkId) {
	 String sql = "INSERT INTO User_Favorite_Artwork (UserID, artworkId) VALUES (?, ?)";
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, userId);
	        stmt.setInt(2, artworkId);
	        
	        int rowsInserted = stmt.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }  
	    
	    return false;
	}
 
 /**
  * Retrieves an Artwork by its ID.
  *
  * @param artworkId The ID of the Artwork to retrieve.
  * @return The Artwork object if found, otherwise null.
  */
 @Override
 public Artwork getArtworkById(int artworkId) {
	    try {	 String sql = "SELECT * FROM Artwork WHERE artworkId = ?";

	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, artworkId);
	        
	        ResultSet rs = stmt.executeQuery(); 
	        
	        if (rs.next()) {
	            Artwork art = new Artwork();
	            art.setartworkId(rs.getInt("artworkId"));
	            art.setTitle(rs.getString("title"));
	            art.setDescription(rs.getString("description"));
	            art.setimageUrl(rs.getString("imageUrl"));
	            art.setMedium(rs.getString("Medium"));
	            art.setCreationDate(rs.getDate("CreationDate"));
	            
	            return art;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
 
 
 /**
  * Removes an Artwork from a user's favorites.
  *
  * @param userId    The ID of the user.
  * @param artworkId The ID of the Artwork to be removed from favorites.
  * @return True if removal from favorites is successful, otherwise false.
  */
 @Override
 public boolean removeArtworkFromFavorite(int userId, int artworkId) {
	 String sql = "DELETE FROM User_Favorite_Artwork WHERE UserID = ? AND artworkId = ?";
	    
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, userId);
	        stmt.setInt(2, artworkId);   
	        int rowsDeleted = stmt.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	    
	    return false;
	}

 /**
  * Retrieves a list of Artworks marked as favorites by a user.
  *
  * @param userId The ID of the user.
  * @return List of Artworks marked as favorites by the user.
  */
 @Override
 public List<Artwork> getUserFavoriteArtworks(int userId) {
	 List<Artwork> favorites = new ArrayList<>();
	 String sql = "SELECT * FROM User_Favorite_Artwork uf INNER JOIN Artwork a ON a.artworkId = uf.artworkId WHERE uf.UserID = ?";
	 try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, userId);	        
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Artwork art = new Artwork();
	            art.setartworkId(rs.getInt("artworkId"));
	            art.setTitle(rs.getString("title"));
	            art.setDescription(rs.getString("description"));
	            art.setimageUrl(rs.getString("imageUrl"));
	            art.setMedium(rs.getString("Medium"));
	            art.setCreationDate(rs.getDate("CreationDate"));
	            favorites.add(art); 
	        }
	    } 
	 catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return favorites;
	}

}

