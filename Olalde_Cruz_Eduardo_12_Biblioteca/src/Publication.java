/**
 * A Publication class that holds the title and author data of any publication.
 * It's a parent class meant to hold the common data of the inheriting classes
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public abstract class Publication {
	
	private String title;
	private String author;

	
	/**
	 * Creates a new Publication with no registered title or author
	 */
	public Publication() {
		this.title = " ";
		this.author = " ";
	}
	
	/**
	 * Fully parameterized constructor for Publication
	 * @param title provides the title
	 * @param author provides the author
	 */
    public Publication(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    /**
     * gets the title of a Publication
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * sets the title of a Publication
     * @param pTitle provides the new title
     */
    public void setTitle(String pTitle) {
    	this.title = pTitle;
    }
    
    /**
     * gets the author of a Publication
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * sets the author of a Publication
     * @param pAuthor provides the new author
     */
    public void setAuthor(String pAuthor) {
    	this.author = pAuthor;
    }
    
    /**
     * @return the title and author of a Publication in the format of a String
     */
    public String toString() {
        return "Title: " + this.title + ", Author: " + this.author;
    }
}
