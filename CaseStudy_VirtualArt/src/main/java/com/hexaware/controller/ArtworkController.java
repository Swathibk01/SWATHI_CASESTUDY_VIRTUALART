package com.hexaware.controller;

import com.hexaware.dao.VirtualArtGalleryImpl;
import com.hexaware.entity.Artwork;
import com.hexaware.exception.ArtWorkNotFoundException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Controller class for managing Artwork operations.
 */
public class ArtworkController {	
    private final VirtualArtGalleryImpl artworkDao;
    
    /**
     * Constructor initializing ArtworkController with VirtualArtGalleryImpl.
     */
    public ArtworkController() {
    	this.artworkDao = new VirtualArtGalleryImpl();
    	}
    
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Method to add an Artwork to the system.
     *
     * @param artwork    The Artwork object to be added.
     * @param scanner2   Scanner object for user input.
     * @return           Boolean indicating successful addition.
     */
    
    public boolean addArtwork(Artwork artwork, Scanner scanner2) {
    	System.out.println("Enter ArtworkID:");
        int artworkID1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline left after nextInt()
        
        System.out.println("Enter Title:"); //Enter artwork Title
        String title1 = scanner.nextLine();

        System.out.println("Enter Description:"); //Enter artwork Description
        String description1 = scanner.nextLine();

        System.out.println("Enter the date in YYYY-MM-DD format:"); //Enter Date 
        String userInput1 = scanner.nextLine();
        Date creationDate1 = Date.valueOf(userInput1);

        System.out.println("Enter Medium:"); //enter medium to artwork
        String medium1 = scanner.nextLine();

        System.out.println("Enter Image URL:"); //enter imageURL to add
        String imageUrl1 = scanner.nextLine();

        // Creating an Artwork object with user-provided details
        Artwork newArtwork = new Artwork();
        newArtwork.setartworkId(artworkID1);
        newArtwork.setTitle(title1);
        newArtwork.setDescription(description1);
        newArtwork.setCreationDate(creationDate1);
        newArtwork.setMedium(medium1);
        newArtwork.setimageUrl(imageUrl1);

        return artworkDao.addArtwork(newArtwork);
        }
    
    /**
     * Method to update an Artwork with user input.
     *
     * @param scanner    Scanner object for user input.
     * @return           Boolean indicating successful update.
     * @throws ArtWorkNotFoundException If Artwork is not found.
     */
    
    public boolean updateArtworkWithInput(Scanner scanner) throws ArtWorkNotFoundException {
    	try {
    		System.out.println("Enter ArtworkID to update:"); //Enter Existing artworkID
		    int artworkID = scanner.nextInt();
		    scanner.nextLine(); // Consume newline character
		
		    System.out.println("Enter new title:"); //enter updated artwork title
		    String title = scanner.nextLine();
		
		    System.out.println("Enter new description:"); //enter description to update
		    String description = scanner.nextLine();

		    System.out.println("Enter the date in YYYY-MM-DD format:"); //enter new date 
		    String userInput = scanner.nextLine();
		    Date creationDate = Date.valueOf(userInput);
		    
		    System.out.println("Enter new medium:"); //enter new medium
		    String medium = scanner.nextLine();
		    
		    System.out.println("Enter new imageurl:"); //enter new imageURL
		    String imageURL = scanner.nextLine();
		    
		    Artwork updatedArtwork = new Artwork();
		    updatedArtwork.setartworkId(artworkID);
		    updatedArtwork.setTitle(title);
		    updatedArtwork.setDescription(description);
		    updatedArtwork.setCreationDate(creationDate);
		    updatedArtwork.setMedium(medium);
		    updatedArtwork.setimageUrl(imageURL);
		    return updateArtwork(updatedArtwork);
		        } catch (ArtWorkNotFoundException e) {
		            // Handle the exception (e.g., prompt the user to enter a valid ID)
		            System.out.println(e.getMessage());
		            throw e;}
		    }
    
    /**
     * Method to update an Artwork.
     *
     * @param updatedArtwork The updated Artwork object.
     * @return               Boolean indicating successful update.
     * @throws ArtWorkNotFoundException If Artwork is not found.
     */

    public boolean updateArtwork(Artwork updatedArtwork) throws ArtWorkNotFoundException {
    	return artworkDao.updateArtwork(updatedArtwork);
    	}
    
    /**
     * Method to remove an Artwork.
     *
     * @param artworkId The ID of the Artwork to be removed.
     * @return          Boolean indicating successful removal.
     */
    
    public boolean removeArtwork(int artworkId) {
        return artworkDao.removeArtwork(artworkId);
    }

    /**
     * Method to get an Artwork by ID.
     *
     * @param artworkId The ID of the Artwork to retrieve.
     * @return          The Artwork object if found, otherwise null.
     */
    
    public Artwork getArtworkById(int artworkId) {
        return artworkDao.getArtworkById(artworkId);
    }
    
    /**
     * Method to search Artworks by keyword.
     *
     * @param keyword The keyword to search for in Artwork titles or descriptions.
     * @return        List of Artworks matching the keyword.
     */
    
    public List<Artwork> searchArtworks(String keyword) {
        return artworkDao.searchArtworks(keyword);
    }

    /**
     * Method to add an Artwork to a user's favorites.
     *
     * @param userId    The ID of the user.
     * @param artworkId The ID of the Artwork to add to favorites.
     * @return          Boolean indicating successful addition to favorites.
     */
    
    public boolean addArtworkToFavorite(int userId, int artworkId) {
        return artworkDao.addArtworkToFavorite(userId, artworkId);
    }
    
    /**
     * Method to remove an Artwork from a user's favorites.
     *
     * @param userId    The ID of the user.
     * @param artworkId The ID of the Artwork to remove from favorites.
     * @return          Boolean indicating successful removal from favorites.
     */
    
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        return artworkDao.removeArtworkFromFavorite(userId, artworkId);
    }

    /**
     * Method to get a user's favorite Artworks.
     *
     * @param userId The ID of the user.
     * @return       List of Artworks marked as favorites by the user.
     */
    
    public List<Artwork> getUserFavoriteArtworks(int userId) {
        return artworkDao.getUserFavoriteArtworks(userId);
    }
}
