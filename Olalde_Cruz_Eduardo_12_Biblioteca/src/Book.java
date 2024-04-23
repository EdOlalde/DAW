/**
 * A Book class that contains information specific for books, able to hold the genre and number of pages
 * of a publication, in addition to the data held by the parent class Publication
 * @see Publication
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public class Book extends Publication {
	
	private String genre;
	private int numPages;
	
	
	/**
	 * Empty constructor for Book
	 */
	public Book() {
		super();
		this.genre = " ";
		this.numPages = 0;
	}
	
	/**
	 * Fully parameterized constructor for Book
	 * @param title provides the title
	 * @param author provides the author
	 * @param genre provides the genre
	 * @param numPages provides the numer of pages
	 */
    public Book(String title, String author, String genre, int numPages) {
        super(title, author);
        this.genre = genre;
        this.numPages = numPages;
    }
    
    /**
     * Gets the genre of a Book
     * @return the genre of the Book
     */
    public String getGenre() {
        return this.genre;
    }
    
    /**
     * Sets the genre of a Book
     * @param pGenre provides the new genre
     */
    public void setGenre(String pGenre) {
    	this.genre = pGenre;
    }
    
    /**
     * Gets the number of pages of a Book
     * @return the number of pages in int format
     */
    public int getNumPages() {
        return this.numPages;
    }
    
    /**
     * Sets the number of pages of a Book
     * @param pNumPages provides the new number of pages
     */
    public void setNumPages(int pNumPages) {
    	this.numPages = pNumPages;
    }
    
    /**
     * Overrides Publication's toString method to include Book's information
     */
    @Override
    public String toString() {
        return super.toString() + ", Genre: " + this.genre + ", Number of Pages: " + this.numPages;
    }

}
