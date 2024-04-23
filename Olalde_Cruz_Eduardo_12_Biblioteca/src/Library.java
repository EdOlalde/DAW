/**
 * Class meant to create libraries of publications constituted by the Publication class
 * @see Publication
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public class Library {
	
	private Publication[] availablePublications;
    
    /**
     * Empty constructor for Library with a default Library size
     */
	public Library() {
		this.availablePublications = new Publication[200];
	}
	
	/**
	 * Fully parameterized constructor for Library adjustable in size
	 * @param capacity provides the size of the Library
	 */
    public Library(int capacity) {
        this.availablePublications = new Publication[capacity];
    }
    
    /**
     * Gets the available publications in the Library
     * @return an array of Publications
     */
    public Publication[] getAvailablePublications() {
    	return this.availablePublications;
    }
    
    /**
     * Gets the available publications in the Library
     * @param pAvailablePublications provides the new array of Publications
     */
    public void setAvailablePublications(Publication[] pAvailablePublications) {
    	this.availablePublications = pAvailablePublications;
    }
    
    /**
     * Adds a Publication to the Library in the first null index
     * @param publication provides the Publication to add
     */
    public void addPublication(Publication publication) {
    	boolean added = false;
    	for(int i=0; i < availablePublications.length && added == false; i++)
    	{
    		if(this.availablePublications[i] == null)
    		{
    			this.availablePublications[i] = publication;
    			added = true;
    		}
    	}
    }
    
    /**
     * Removes a Publication from the Library
     * @param publication provides publication the Publication to be removed
     */
    public void removePublication(Publication publication) {
    	boolean removed = false;
    	for(int i=0; i < availablePublications.length && removed == false; i++)
    	{
    		if(this.availablePublications[i] == publication)
    		{
    			this.availablePublications[i] = null;
    			removed = true;
    		}
    	}
     
    }
    
    /**
     * Search a Library for Publications by a provided author
     * @param author provides the target author
     */
    public void searchPublicationsByAuthor(String author) {
    	
    	boolean found = false;
    	for(int i=0; i < this.availablePublications.length; i++)
    	{
    		if (availablePublications[i] != null && this.availablePublications[i].getAuthor().equals(author))
    		{
    			if (found == false)
    			{
    				found = true;
    				System.out.println("\n" + author + " has this publications available: ");
    			}
    			System.out.println(" --- " + this.availablePublications[i].toString());
    		} 		
    	}
    	if(found == false) 
		{
			System.out.println("There are no publications available by " + author);
		}
       
    }
    
    /**
     * Method that checks if a title is available in a given array of Publications
     * @param title provides the title to look for
     * @return a true or false boolean indicating whether the title has been found or not
     */
    public boolean searchPublicationsByTitle(String title) {
    	
    	boolean found = false;
    	for(int i=0; i < this.availablePublications.length; i++)
    	{
    		if (this.availablePublications[i] != null && this.availablePublications[i].getTitle().equals(title))
    		{ 		
    				found = true;
    		} 		
    	}
    	return found;
    }
    
    /**
     * Method that searches a Library for all distinct available authors
     * @return a String array containing all the different authors
     */
    public String[] searchAuthorsAvailable() {
    	
    	String[] authors = new String[this.availablePublications.length];
    	boolean alreadyFound = false;
    	
    	for(int i=0; i < this.availablePublications.length; i++)
    	{
    		alreadyFound = false;
    		if(this.availablePublications[i] != null)
    		{
    			for(int j=0; j < this.availablePublications.length && alreadyFound == false; j++)
        		{
        			if(authors[j] != null && authors[j].equals(this.availablePublications[i].getAuthor()))
        			{
        				alreadyFound = true;
        			}
        			else if(authors[j] == null)
        			{
        				authors[j] = this.availablePublications[i].getAuthor();
        				alreadyFound = true;
        			}
        		}
    		}    		
    	}
    	return authors;
    }
    
    /**
     * Searches the library for a Publication by a title and returns it. Returns an empty Book if it's not found
     * @param title provides the target title
     * @return the target Publication, or an empty Book
     */
    public Publication getPublicationByTitle(String title) {
    	
    	Publication publicationHolder = new Book();
    	boolean found = false;
    	for(int i=0; i < this.availablePublications.length && found == false; i++)
    	{
    		if (availablePublications[i] != null && this.availablePublications[i].getTitle().equals(title))
    		{
    			found = true;
    			publicationHolder = availablePublications[i];
    		} 		
    	}
    	return publicationHolder;
    }
    
   /**
    * Method that removes a publication from the Library and adds it to the user's read list
    * @param user provides the user that borrows the publication
    * @param publication provides the publication borrowed
    */
    public void lendPublication(User user, Publication publication) {
    	boolean found = false;
    	for(int i=0; i < this.availablePublications.length && found == false; i++)
    	{
    		if (availablePublications[i] != null && this.availablePublications[i].equals(publication))
    		{
    			found = true;
    			System.out.println(user.getUsername() + " has rented " + this.availablePublications[i].getTitle() 
    					+ " by " + this.availablePublications[i].getAuthor());
    			removePublication(publication);
    			user.addPublication(publication);			
    		}
    	}
    	if(found == false)
    	{
    		System.out.println("That publication isn't available.");
    	}
       
    }
    
    
    /**
     * Method that adds back a Publication to the Library
     * @param user provides the User
     * @param publication provides the Publication
     */
    public void returnPublication(User user, Publication publication) {    
    		addPublication(publication);
  	
    }
    
}
