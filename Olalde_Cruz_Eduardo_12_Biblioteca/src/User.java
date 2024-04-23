/**
 * User class meant to contain user data relating to the class Library
 * @see Library
 * @see Publication
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public class User {

	private String username;
	private String password;
	private Publication[] publicationsRead;
	
    
	/**
	 * Empty constructor for User with empty fields and a deafult
	 * read publication library size
	 */
	public User() {
		this.username = "";
		this.password = " ";
		this.publicationsRead = new Publication[200];
	}
	
	/**
	 * Partially parameterized constructor for User that sets a default read list size
	 * @param username provides the username
	 * @param password provides the password
	 */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.publicationsRead = new Publication[200];
    }
	
	/**
	 * Fully parameterized constructor for User
	 * @param username provides the username
	 * @param password provides the password
	 * @param capacity provides the capacity of the user's reads library array
	 */
    public User(String username, String password, int capacity) {
        this.username = username;
        this.password = password;
        this.publicationsRead = new Publication[capacity];
    }
    
    /**
     * Gets the username of a User
     * @return the username in String format
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Sets the username of a User
     * @param pUsername provides the new username
     */
    public void setUsername(String pUsername) {
    	this.username = pUsername;
    }
    
    /**
     * Gets the password of a User
     * @return the password in String format
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Set the password of a User
     * @param pPassword provides the new password
     */
    public void setPassword(String pPassword) {
    	this.password = pPassword;
    }
    
    /**
     * Gets an array containing the the read publications of a User
     * @return the publications read in the format of an array of Publications
     */
    public Publication[] getPublicationsRead() {
        return this.publicationsRead;
    }
    
    /**
     * Sets an array containing the the read publications of a User
     * @param pPublicationsRead provides the new array of read publications
     */
    public void setPublicationsRead(Publication[] pPublicationsRead) {
    	this.publicationsRead = pPublicationsRead;
    }
    
    /**
     * Adds a publication read by a user to their library
     * @param publication provides the read Publication
     */
    public void addPublication(Publication publication) {

    	boolean publicationAdded = false;
           	for(int i=0; i < this.publicationsRead.length; i++)
           	{
           		if(this.publicationsRead[i] == null && publicationAdded == false)
           		{
           			this.publicationsRead[i] = publication;
           			System.out.println("Publication added to " + this.username + "'s read list.");
           			publicationAdded = true;
           		}
           	}
            
    }
    
    /**
     * Method that searches a Library for a publication based on the author of the first read of the user    
     * @param library inputs the Library to be searched
     */
    public void getRecommendedPublications(Library library) {
    	
    	String author = " ";
    	String title = " ";
    	boolean foundPublication = false;
    	
    	for(int i=0; i < this.publicationsRead.length && foundPublication == false; i++)
    	{
    		if(this.publicationsRead[i] != null)
    		{
    			author = this.publicationsRead[i].getAuthor();
    	    	title = this.publicationsRead[i].getTitle();
    	    	foundPublication = true;
    		}		
    	}
    	foundPublication = false;
    	
    	for(int i=0; i < library.getAvailablePublications().length && foundPublication == false; i++)
    	{
    		if(library.getAvailablePublications()[i] != null && library.getAvailablePublications()[i].getAuthor().equals(author) 
    				&& !library.getAvailablePublications()[i].getTitle().equals(title))
    				{
    					System.out.println("Because you have read " + title + " by " + author + 
    							", you may like "
    							+ library.getAvailablePublications()[i].getTitle() + " by "
    							+ library.getAvailablePublications()[i].getAuthor());
    					foundPublication = true;
    				}    		
    	}
    	
    	if(foundPublication == false) System.out.println("Sorry, I can't recommend any other books based on"
				+ " what you have read before");
    	
    }
    
    /**
     * Method to check if a user has entered a valid password
     * @param pass inputs a password
     * @return true boolean if the password is correct, false if not
     */
    public boolean checkPassword(String pass) {
    	boolean validPassword = false;
    	if(pass.equals(this.password)) validPassword = true;
    	
    	return validPassword;
    }
    
    /**
     * Method that checks if a Publication by a given title is in the user's read's list
     * @param title provides the title to be checked
     * @return a true or false boolean for found or not found
     */
    public boolean searchPublicationsByTitle(String title) {
    	
    	boolean found = false;
    	for(int i=0; i <this.publicationsRead.length; i++)
    	{
    		if (this.publicationsRead[i] != null && this.publicationsRead[i].getTitle().equals(title))
    		{ 		
    				found = true;
    		} 		
    	}
    	return found;
    }
}
