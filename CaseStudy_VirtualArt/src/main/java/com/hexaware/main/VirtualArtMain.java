package com.hexaware.main;

import com.hexaware.controller.ArtworkController;
import com.hexaware.controller.UserController;
import com.hexaware.dao.GalleryDao;
import com.hexaware.dao.GalleryDaoImpl;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import com.hexaware.entity.User;
import com.hexaware.exception.ArtWorkNotFoundException;
import com.hexaware.exception.UserNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * The main class representing the Virtual Art Gallery System.
 * This class contains the entry point and user interaction methods.
 */
public class VirtualArtMain {
	
	/**
     * The main method of the application.
     * It initializes controllers and manages user interactions. 
     * @param args The command-line arguments passed to the program.
     * 
     */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		UserController userController = new UserController();
        ArtworkController artworkController = new ArtworkController();
        GalleryDao galleryDAO = new GalleryDaoImpl();
        boolean exit = false;
        while (!exit) 
        {
        	// Display menu options for the user
        	System.out.println("Virtual Art Gallery System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("Enter your choice:");
            //choice to be entered by user
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) 
            {
            case 1:
            	System.out.println("Enter username to validate:");
                String usernameToValidate = new java.util.Scanner(System.in).nextLine();
                System.out.println("Enter password to validate:");
                String passwordToValidate = new java.util.Scanner(System.in).nextLine();
                User validatedUser = userController.validateUser(usernameToValidate, passwordToValidate);
                try 
                {
                	if (validatedUser != null) 
                	{
                		boolean continueOption = true;
                        while (continueOption) {
                        System.out.println("User validated successfully:");
                        System.out.println("User ID: " + validatedUser.getUserId());
                        System.out.println("Choose \n 1.Artwork Management \n 2.Gallery Management");
                        int in=scanner.nextInt();
                        //Artwork Management functions
                        if(in==1) {
                        System.out.println("Enter option");
                        System.out.println("1. add artwork");
                        System.out.println("2. update artwork");
                        System.out.println("3. remove artwork");
                        System.out.println("4. getartworkbyid");
                        System.out.println("5.search artworks");
                        System.out.println("6.addartwork to favourites");
                        System.out.println("7.remove artworkfrom favourite");
                        System.out.println("8. get userfavourite artwork");
                        int option1 = scanner.nextInt();
                        switch(option1) {
                        case 1: 
                        	//Add artwork to artwork table
                            Artwork newArtwork = new Artwork(); // Create an Artwork object
                            boolean isArtworkAdded = artworkController.addArtwork(newArtwork, scanner);
                            if (isArtworkAdded) {
                            	System.out.println("Artwork added successfully.");
                            	}
                            else {
                            	System.out.println("Failed to add artwork.");
                            	}
                            break;
                         case 2:
                        	 //update artwork in artwork table
                             try {
                            	 boolean isUpdated = artworkController.updateArtworkWithInput(scanner);
                            	 if (isUpdated) {
                            		 System.out.println("Artwork updated successfully.");
                                        } 
                            	 else {
                            		 System.out.println("Failed to update artwork.");
                            		 }
                            	 } 
                             catch (ArtWorkNotFoundException e) {
                            	 System.out.println(e.getMessage());
                             }
                             break;
                         case 3:
                        	 //removal of artwork using artworkID
                        	 System.out.println("Enter artworkID");
                        	 int artworkIdToRemove = scanner.nextInt(); 
                        	 try
                        	 {
                        		 boolean removed = artworkController.removeArtwork(artworkIdToRemove);
                                 if (removed) {
                                	 System.out.println("Artwork removed successfully!");
                                    } 
                                 else  
                                	 throw new ArtWorkNotFoundException("Artwork not found with ID: " + artworkIdToRemove);
                                	} 
                        	 catch (ArtWorkNotFoundException e) {
                        		 System.out.println(e.getMessage());
                                	}
                        	 break;
                          case 4:
                        	  //retrieve artwork using artworkID
                        	  System.out.println("Enter artworkID");
                        	  int artworkIdToRetrieve= scanner.nextInt();
                              Artwork retrievedArtwork = artworkController.getArtworkById(artworkIdToRetrieve);
                              if (retrievedArtwork != null) {
                            	  System.out.println("Retrieved Artwork: " + retrievedArtwork);
                            	  } 
                              else {
                            	  System.out.println("Artwork not found.");
                            	  }
                              break;
                          case 5:
                        	  //search artwork using keyword
                              System.out.println("Enter keyword : Title or Description");
                              String keyword=scanner.next();
                              List<Artwork> Artworks = artworkController.searchArtworks(keyword);
                              System.out.println("Artworks: " + Artworks);
                              break;
                          case 6:
                        	  //add artwork to artwork_favourite 
                        	  System.out.println("Enter UserID");
                              int userId=scanner.nextInt();
                              System.out.println("Enter artworkID");
                              int artworkId=scanner.nextInt();
                              boolean addedd = artworkController.addArtworkToFavorite(userId, artworkId);
                              if (addedd) 
                              {
                            	  System.out.println("Artwork added to favorites successfully!");
                            	  } 
                              else {
                            	  System.out.println("Failed to add artwork to favorites.");
                            	  }
                              break;
                          case 7:
                        	   //remove artwork from artwork_favourite
                        	   System.out.println("Enter UserID");
                               int userId1=scanner.nextInt();
                               System.out.println("Enter artworkID");
                               int artworkId1=scanner.nextInt();
                               boolean removedd = artworkController.removeArtworkFromFavorite(userId1, artworkId1);
                               if (removedd) 
                               {
                            	   System.out.println("Artwork removed from favorites successfully!");
                            	   }
                               else {
                            	   System.out.println("Failed to remove artwork from favorites.");
                                    }
                               break;
                          case 8:
                        	  //get user favorite artwork from artwork_favourite
                        	  System.out.println("Enter UserID");
                              int userId2 = scanner.nextInt();
                              List<Artwork> userFavorites = artworkController.getUserFavoriteArtworks(userId2);
                              if (!userFavorites.isEmpty()) {
                              System.out.println("User Favorites:");
                              for (Artwork artwork : userFavorites) {
                              System.out.println(artwork);
                            	  }
                              } 
                              else {
                            	  System.out.println("No favorites found for the user.");
                                    }
                              break;
                          default:
                        	  //invalid choice entered by user
                        	  System.out.println("Invalid Option");
                              break;
                            }
                        }
                        else 
                        {
                        	//Gallery Management functions
                        	System.out.println("Welcome to the Virtual Art Gallery System!");
	                        System.out.println("1. Add Gallery");
	                        System.out.println("2. Update Gallery");
	                        System.out.println("3. Remove Gallery");
	                        System.out.println("4. Get Gallery by ID");
	                        System.out.println("5. Search Galleries");
	                        System.out.println("Choose an option:");
	                        //enter choice to perform gallery functions
	                        int choice1 = scanner.nextInt();
	                        scanner.nextLine(); 
	                        switch (choice1) {
                            case 1:
                            	//add a new gallery
                                Gallery newGallery = new Gallery();
                                System.out.println("Enter Gallery ID to add:");
                                newGallery.setgalleryId(scanner.nextInt());
                                System.out.println("Enter Name to add:");
                                newGallery.setName(scanner.next());
                                System.out.println("Enter Description to add:");
                                newGallery.setDescription(scanner.next());
                                System.out.println("Enter Location to add: ");
                                newGallery.setLocation(scanner.next());  
                                boolean isAdded = galleryDAO.addGallery(newGallery);
                                if (isAdded) {
                                    System.out.println("Gallery added successfully!");
                                } else {
                                    System.out.println("Failed to add the gallery.");
                                }
                                break;
                            case 2:
                                // update a gallery
                            	Gallery updatedGallery = new Gallery();
                                System.out.println("Enter Gallery ID to update:");
                                updatedGallery.setgalleryId(scanner.nextInt());
                                System.out.println("Enter Name to update:");
                                updatedGallery.setName(scanner.next());
                                System.out.println("Enter Description to update:");
                                updatedGallery.setDescription(scanner.next());
                                System.out.println("Enter Location to update: ");
                                updatedGallery.setLocation(scanner.next());
                                 
                                boolean isUpdated = galleryDAO.addGallery(updatedGallery);
                                if (isUpdated) {
                                    System.out.println("Gallery updated successfully!");
                                } 
                                else {
                                	System.out.println("Failed to update the gallery.");
                                }
                            	break;
                            case 3:
                            	//remove a gallery
                                System.out.println("Enter Gallery ID to remove:");
                                int galleryIdToRemove = scanner.nextInt();
                                boolean isRemoved = galleryDAO.removeGallery(galleryIdToRemove);
                                if (isRemoved) {
                                    System.out.println("Gallery removed successfully!");
                                } else {
                                    System.out.println("Failed to remove the gallery.");
                                }
                                break;
                            
                            case 4:
                                //search from gallery using keyword
                                System.out.println("Enter keyword to search galleries:Name or Description");
                                String keyword = scanner.nextLine();
                                List<Gallery> searchedGalleries = galleryDAO.searchGalleries(keyword);
                                if (!searchedGalleries.isEmpty()) {
                                	System.out.println("Search results:");
                                    for (Gallery gallery : searchedGalleries) {
                                    	System.out.println(gallery);
                                    	}
                                    } 
                                else {
                                	System.out.println("No galleries found matching the keyword.");
                                	}
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                }
	                        }
                        System.out.println("Do you want to continue? (yes/no)");
                        String continueChoice = scanner.next();
                        if (continueChoice.equalsIgnoreCase("no")) {
                        	continueOption = false;
                            }
                        }
                        }
                	else throw new UserNotFoundException("User not found with ID: " + usernameToValidate);
                	}
                catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
                }
                break;
            case 2:
            	//register new user
            	User newUser = userController.getUserDetails(scanner);
                userController.registerUser(newUser);
                System.out.println("User registered successfully.");
                break;
            default:
            	//invalid choice given
            	System.out.println("Invalid choice. Please try again.");
            	break;
            	}
            System.out.println("Thank you. Exiting the Virtual Art Gallery System.");
        }
    }
}
