/**
 * The <code>Book</code> class implements a class of <code>Book</code> objects.
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 **/
public class Book 
{
    private String title; // Title of the book
    private String author; // Name of the author
    private String borrower; // Name of the borrower
    private int condition; // Condition of the book (1-5)
    
    /**
     * Creates a <code>Book</code> object
     * 
     * @param nTitle
     *      Title of the book as typed by the user.
     * @param nAuthor
     *      Name of the author as typed by the user.
     * @param nCondition 
     *      Condition of the book as said by the user.
     * 
     * <dt>Precondition:
     *  <dd><code>nCondition</code> is greater than 0 or less than 6.
     * 
     **/
    public Book(String nTitle, String nAuthor, int nCondition)
    {
        this.title = nTitle;
        this.author = nAuthor;
        this.condition = nCondition;
        this.borrower = "<none>";  
    }
    
    /**
     * Returns the title of the book.
     * 
     * @return 
     *      Returns the title of the book.
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Sets a new title of the book.
     * 
     * @param newTitle 
     *      Sets the new title of the book as the String in newTitle.
     * 
     * <dt>Postconditions:
     *    <dd>The title of the book will be changed.
     * 
     */
    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }
    
    /**
     * Returns the author of the book.
     * 
     * @return 
     *      Returns the author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * Sets a new author of the book.
     * 
     * @param newAuthor 
     *      Sets the name of the author as the String in newAuthor.
     * 
     * <dt>Postconditions:
     *    <dd>The author's name will be changed.
     */
    public void setAuthor(String newAuthor)
    {
        this.author = newAuthor;
    }
    
    /**
     * Returns the condition of the book.
     * 
     * @return 
     *      Returns the condition of the book.
     * 
     */
    public int getCondition()
    {
        return this.condition;
    }
    
    /**
     * Sets the condition of the book.
     * 
     * @param newCondition
     *      Sets the condition of the book as the integer in newCondition.
     *
     * <dt>Precondition:
     *  <dd>The newCondition should be greater than 0 and below 6.
     * 
     * <dt>Postconditions:
     *    <dd>The condition of the book will be changed.
     */
    public void setCondition(int newCondition)
    {
        this.condition = newCondition;
    }
    
    /**
     * Returns the borrower of the book.
     * 
     * @return 
     *      Returns the name of the borrower of the book.
     */
    public String getBorrower()
    {
        return this.borrower;
    }
    
    /**
     * Sets the borrower of the book.
     * 
     * @param newBorrower 
     *      Sets the name of the borrower of the book based on the String in newBorrower.
     */
    public void setBorrower(String newBorrower)
    {
        this.borrower = newBorrower;
    }
    
    /**
     * Checks if the two books are equal.
     * 
     * @param o
     *      The method takes in an object to compare whether it is equal to the 
     *      instance object.
     * 
     * @return 
     *      Returns a boolean stating whether the two objects are equal or not.
     * 
     * <dt>Postconditions:
     *    <dd>The name of the borrower will be changed.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Book)
        {
            Book book1 = (Book) o;
            
            if (this.author.equals(book1.author))
            {
                if(this.title.equals(book1.title))
                {
                    if(this.condition == book1.condition)
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Creates a clone of the book.
     * 
     * @return 
     *      Returns the clone of the instance object. Does not copy the borrower
     *      if the object contains one.
     * 
     * <dt>Postconditions:
     *    <dd>A clone of the <code>book</code> object will be created.
     */
    @Override
    public Book clone()
    {
        Book clone = new Book(this.title, this.author, this.condition);
        
        return clone;
    }
    
    /**
     * Returns the properties of a book.
     * 
     * @return
     *      Returns information about the <code>Book</code> object in the form
     *      of a String. 
     */
    @Override
    public String toString()
    {
        return String.format("%-60s %-34s %-12d %-13s\n", this.title, this.author, 
                this.condition, this.borrower);
    }
}