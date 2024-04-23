/**
 * A Magazine class that contains information specific for magazines, able to hold the genre and number of pages
 * of a publication, in addition to the data held by the parent class Publication
 * @see Publication
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public class Magazine extends Publication {

	private int issueNumber;
	private String publishDate;
	
	/**
	 * Empty constructor for Magazine
	 */
	public Magazine() {
		super();
		this.issueNumber = 0;
		this.publishDate = " ";
	}
	
	/**
	 * Fully parameterized constructor for Magazine
	 * @param title provides the title
	 * @param author provides the author
	 * @param issueNumber provides the issue number
	 * @param publishDate provides the publishing date
	 */
    public Magazine(String title, String author, int issueNumber, String publishDate) {
        super(title, author);
        this.issueNumber = issueNumber;
        this.publishDate = publishDate;
    }
    
    /**
     * Gets the issue number of a Magazine
     * @return the issue number
     */
    public int getIssueNumber() {
        return this.issueNumber;
    }
    
    /**
     * Sets the issue number of a Magazine
     * @param pIssueNumber provides the new issue number
     */
    public void setIssueNumber(int pIssueNumber) {
    	this.issueNumber = pIssueNumber;
    }
    
    /**
     * Gets the publishing date of a Magazine
     * @return the publishing date in String format
     */
    public String getPublishDate() {
        return this.publishDate;
    }
    
    /**
     * Sets the publishing date of a Magazine
     * @param pPublishDate provides the new publishing date
     */
    public void setPublishDate(String pPublishDate) {
    	this.publishDate = pPublishDate;
    }
    
    /**
     * Overrides Publication's toString method to include Magazine's information
     */
    @Override
    public String toString() {
        return super.toString() + ", Issue Number: " + this.issueNumber + ", Publish Date: " + this.publishDate;
    }
	
}
