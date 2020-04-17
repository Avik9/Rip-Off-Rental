/**
 * The <code>Bookshelf</code> class implements a class of multitudinous 
 * <code>Book</code> objects. 
 * 
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * 
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * 
 * Recitation: CSE 214 - R.14
 */

public class Bookshelf 
{
    private Book [] books; // An array holding the items in the bookshelf.
    private int count; // The number of items currently in the bookshelf.
    final int CAPACITY = 20; // The size of the bookshelf.
    
    /**
     * Constructor for bookshelf.
     * 
     * <dt>Preconditions:
     *  <dd>The <code>CAPACITY</code> is equal to 20.
     *  <dd>The count starts off at 0 because there are no books when the
     *      bookshelf is initiated.
     */
    public Bookshelf()
    {
        books = new Book[CAPACITY];
        count = 0;
    }
    
    /**
     * Returns the number of books on the bookshelf.
     * 
     * @return 
     *      Returns the number of books currently in the bookshelf.
     */
    public int numBooks()
    {
        return count;
    }
    
    /**
     * Gets the book in the index specified on the bookshelf.
     * 
     * @param index
     *      Returns the book at the index in the bookshelf.
     * 
     * @return
     *      Returns the <code>Book</code> object.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *      Indicates that the value in index is either greater than 19 or less 
     *      than 0.
     * 
     * <dt>Precondition:
     *  <dd>The index is greater than 0 and below count.
     **/
    public Book getBook(int index) throws Exception
    {
        if(index > this.count || index < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        return books[index];
    }
    
    /**
     * Removes the book at the specified index.
     * 
     * @param index
     *      Removes the book at the index in the bookshelf.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *      Indicates that the value in index is either greater than 19 or less 
     *      than 0.
     * 
     * @throws EmptyShelfException
     *      Indicates that the shelf is empty and there are no book present on 
     *      that spot on the shelf.
     * 
     * <dt>Precondition:
     *  <dd>The index is greater than 0 and below count.
     * 
     * <dt>Postconditions:
     *    <dd>The book at index is removed.
     */
    public void removeBook(int index) throws Exception
    {
        if(index > books.length || index > count + 1 || index < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if(books[index] == null)
        {
            throw new EmptyShelfException();
        }
        
        else
        {
            books[index] = null;
            
            for(int i = index; i < books.length - 1; i++)
            {
                books[i] = books[i + 1];
            }
        }
        
        count--;
    }
    
    /**
     * Adds a Book to the specified index.
     * 
     * @param index
     *      Adds the book at the given index in the bookshelf.
     * 
     * @param book
     *      The <code>Book</code> object that gets added to the bookshelf.
     * 
     * <dt>Precondition:
     *  <dd>The index is greater than 0 and below 20.
     * 
     * <dt>Postconditions:
     *    <dd>The book is added to the bookshelf.
     * 
     * @throws IllegalArgumentException
     *      Indicates that the value entered for index is either above 20 or 
     *      below 0.
     * 
     * @throws FullShelfException if the shelf cannot hold anymore books.
     */
    public void addBook(int index, Book book) throws Exception
    {
        if(index > 20 || index < 0)
        {
            throw new IllegalArgumentException();
        }
        
        if (count > 20)
        {
            throw new FullShelfException();
        }
        
        else
        {
            if(index != (count))
            {
                System.out.println("The index you entered creates a hole in the"
                        + " array. Therefore, the book has been added to the "
                        + "next available index: " + (count + 1));
            }
            
            for(int i = books.length - 1; i > index; i--)
            {
                books[i] = books[i - 1];
            }
            
            books[index] = book;
            
            count++;
        }
    }
    
    /**
     * Swaps the position of the two Books in the bookshelf.
     * 
     * @param index1
     *      The position of the first item to be swapped.
     * 
     * @param index2
     *      The position of the first item to be swapped.
     * 
     * <dt>Precondition:
     *  <dd>index1 and index2 is greater than 0 and below count.
     * 
     * <dt>Postconditions:
     *    <dd>The books at index1 and index2 have been swapped.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *      Indicates that the value for either indices are below 0 or 
     *      above count.
     */
    public void swapBooks(int index1, int index2) throws Exception
    {
        if(index1 > books.length || index1 > count + 1 || index1 < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if(index2 > books.length || index2 > count + 1|| index2 < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        
        else
        {
            Book clone = books[index1].clone();
            
            books[index1] = books[index2];
            
            books[index2] = clone;
        }
    }
    
    /**
     * Creates a clone of the bookshelf.
     * 
     * @return 
     *      Returns a clone of the <code>Bookshelf</code> object of the instance
     *      variable with everything same but without a borrower.
     * 
     * <dt>Postconditions:
     *    <dd>A clone has been created of the instance object.
     */
    @Override
    public Bookshelf clone()
    {
        Bookshelf newShelf = new Bookshelf();
        
        try
        {
            for(int i = 0; i < this.count; i++)
            {
                newShelf.addBook(i, this.getBook(i).clone());
                newShelf.getBook(i).setBorrower("<none>");
            }
        }
        
        catch (Exception e)
        {
            
        }
        return newShelf;
    }
    
    /**
     * Checks to see if the object in the parameter is equal to the instance variable.
     * 
     * @param o
     *      The method takes in an object to compare whether it is equal to the 
     *      instance object.
     * 
     * @return 
     *      Returns a boolean stating if the two bookshelves are equal.
     */
    public boolean equals(Object o)
    {
        try
        {
//            int counter = 0;
            
            if(o instanceof Bookshelf)
            {   
                Bookshelf shelf0 = (Bookshelf) o;
                
                if(shelf0.count == this.count)
                {
                    for(int i = 0; i < shelf0.count; i++)
                    {
                        if(!shelf0.getBook(i).equals(this.getBook(i)))
                        {
                            return false;
                        }
                    } 
                    return true;
                }
            }
            return false;
        }
        
        catch (Exception e)
        {
            
        }
        
        return false;
    }
    
    /**
     * Returns the list of books on the shelf.
     * 
     * @return 
     *      Returns the Books on the book shelf in a String format.
     */
    public String toString()
    {
        String print = "";
        
        print += String.format("\n%-60s %-30s %-16s %-20s\n", "Title", "Author", 
                "Condition", "Borrower");
        
        print += String.format("----------------------------------------------"
                + "------------------------------------------------------------"
                + "--------------\n");
                
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == null)
            {
                
            }
            else
            {
                print += books[i];
            }
        }
        
        return print;
    }
}