
/**
 * The <code>RipoffRental</code> class manages a book rental company.
 *
 * @author Avik Kadakia email:avik.kadakia@stonybrook.edu
 *
 * Stony Brook ID: 111304945
 *
 * Class: CSE 214.02
 *
 * Recitation: CSE 214 - R.14
 */

import java.util.*;

public class RipoffRental {

    public static Bookshelf shelfA = new Bookshelf(); // An array holding the books in a shelf
    public static Bookshelf shelfB = new Bookshelf(); // An array holding the books in a shelf
    public static Bookshelf shelfC = new Bookshelf(); // An array holding the books in a shelf

    private static Scanner sc = new Scanner(System.in); // A scanner

    public static void main(String[] args) {
        try {
            System.out.println(add()); // Used for testing purposes only.

            System.out.println("Hello!\nWelcome to Jack's aMAzin' Textbook "
                    + "Rentals, highest price guaranteed!\n");

            System.out.print("Please enter a shelf to go to: ");

            chooseShelf();
        } catch (EmptyShelfException a) {
            System.out.println("The shelf is already empty, no more books "
                    + "can be removed.");
        } catch (FullShelfException b) {
            System.out.println("The shelf is full. Please try another shelf.");
        } catch (ArrayIndexOutOfBoundsException c) {
            System.out.println("The number entered is invalid. Please try a "
                    + "different number");
        } catch (IllegalArgumentException d) {
            System.out.println("The index you entered is invalid. Please try "
                    + "a different index. (Tip: maybe a lower number.)");
        } catch (NullPointerException e) {
            System.out.println("The value you are looking for does not exist. "
                    + "Please try a different number. (Tip: maybe a lower number.");
        } catch (Exception f) {
            System.out.println("An error has occured. Please check your values "
                    + "and try again. Sorry for the inconvinience!");
        }
    }

    /**
     * Adds 5 books to the bookshelf - USED FOR TESTING PURPOSES.
     *
     * @return Prints a confirmation statements stating 5 books have been added
     * to the shelf.
     *
     * @throws Exception Indicates if the book being added is invalid or the
     * index it is being added is invalid.
     */
    public static String add() throws Exception {
        Book book1 = new Book("A Brief Introduction to Brief Introductions",
                "Luke Long", 4);

        Book book2 = new Book("PRO-Crastination - A Guide To Efficiency",
                "Oscar Martinez", 5);

        Book book3 = new Book("Introductory Computer Science",
                "TurnItOff AndBackOnAgain", 5);

        Book book4 = new Book("Sing, Unburied, Sing", "Jesmyn Ward", 2);

        Book book5 = new Book("Artemis", "Andy Weir", 1);

        shelfA.addBook(0, book1);
        shelfA.addBook(1, book2);
        shelfA.addBook(2, book4);
        shelfA.addBook(3, book5);
        shelfA.addBook(4, book3);

        return "5 books have been added to Shelf A.";
    }

    /**
     * Prints out the menu with options every time.
     */
    public static void menu() 
    {
        System.out.println("Menu:" + "\n"
                + "\t" + "A) Add Book" + "\n"
                + "\t" + "S) Swap Book" + "\n"
                + "\t" + "L) Loan Book" + "\n"
                + "\t" + "R) Remove Book" + "\n"
                + "\t" + "D) Duplicate Book" + "\n"
                + "\t" + "C) Change Shelf" + "\n"
                + "\t" + "O) Overwrite shelf with clone of current "
                + "shelf" + "\n"
                + "\t" + "E) Check if two shelves are equal" + "\n"
                + "\t" + "P) Print current bookshelf" + "\n"
                + "\t" + "Q) Quit" + "\n");
    }

    /**
     * Scans in the shelf the user wants and sends it to the selectOption()
     * method to continue the task.
     *
     * @throws Exception Indicates that the shelf is invalid.
     */
    public static void chooseShelf() throws Exception {
        String inputShelf = sc.next();

        char iShelf = inputShelf.toUpperCase().charAt(0);

        switch (iShelf) {

            case 'A':
                selectOption(shelfA);
                break;
            case 'B':
                selectOption(shelfB);
                break;
            case 'C':
                selectOption(shelfC);
                break;
            default: {
                System.out.print("Invalid shelf. Please enter the shelf "
                        + "again: ");

                chooseShelf();
            }
        }
    }

    /**
     * Runs all the methods for the options within the menu.
     *
     * @param shelf Takes the shelf to work in as the input
     *
     * <dt>Postcondition(s):
     * <dd>The task(s) chosen by the user are completed.
     *
     * @throws Exception Indicates if an invalid value is entered or the shelf
     * is empty.
     */
    public static void selectOption(Bookshelf shelf) throws Exception {
        menu();

        System.out.print("Please select an option: ");

        String in = sc.next();

        char input = in.toUpperCase().charAt(0);

        sc.nextLine();

        switch (input) {
            case 'A': {
                System.out.print("Please enter a title: ");
                String title = sc.nextLine();

                System.out.print("Please enter an author: ");
                String author = sc.nextLine();

                System.out.print("Please enter a condition (1-5): ");
                int condition = sc.nextInt();

                if (condition <= 5 && condition >= 1) {
                    System.out.print("Please enter a position on the shelf (0-19): ");
                    int position = sc.nextInt();

                    Book book0 = new Book(title, author, condition);

                    shelf.addBook(position, book0);

                    System.out.println("Book has been added!");
                } else {
                    System.out.println("\nInvalid condition. Please enter a "
                            + "number between 1 and 5. Please try adding the "
                            + "book again.\n");

                    selectOption(shelf);

                    break;
                }

                end();
            }
            break;

            case 'S': {
                System.out.print("Please enter an index (0-19): ");
                int index1 = sc.nextInt();

                System.out.print("Please enter another index (0-19): ");
                int index2 = sc.nextInt();

                shelf.swapBooks(index1, index2);

                System.out.println(shelf.getBook(index2).getTitle()
                        + " has swapped with " + shelf.getBook(index1).getTitle());

                end();
            }
            break;

            case 'L': {
                System.out.print("Please enter an index: ");
                int index1 = sc.nextInt();

                System.out.print("Please enter a recipient: ");
                String borrower = sc.next();

                System.out.print("Please enter condition (1-5): ");
                int con = sc.nextInt();

                if (con <= 5 && con >= 1) {
                    shelf.getBook(index1).setCondition(con);

                    shelf.getBook(index1).setBorrower(borrower);

                    System.out.println(shelf.getBook(index1).getTitle()
                            + " has been loaned to " + borrower);

                    end();
                } else {
                    System.out.println("\nInvalid condition. Please enter a "
                            + "number 1 and 5");
                }
            }
            break;

            case 'R': {
                System.out.print("Please enter an index (0-19): ");
                int index1 = sc.nextInt();

                System.out.println(shelf.getBook(index1).getTitle()
                        + " has been removed.");

                shelf.removeBook(index1);

                end();
            }
            break;

            case 'D': {
                System.out.print("Please enter an index (0-19): ");
                int index1 = sc.nextInt();

                System.out.print("Please enter a destination index (0-19): ");
                int index2 = sc.nextInt();

                shelf.addBook(index2, shelf.getBook(index1).clone());

                System.out.println("A new copy of "
                        + shelf.getBook(index1).getTitle() + " is in index " + index2);

                end();
            }
            break;

            case 'C': {
                System.out.print("Please select shelf to look at: ");

                chooseShelf();
            }
            break;

            case 'O': {
                System.out.print("Please select the shelf to overwrite: ");
                String books1 = sc.next().toUpperCase();

                char iBooks1 = books1.charAt(0);

                switch (iBooks1) {

                    case 'A': {
                        shelfA = shelf.clone();
                        System.out.println("Shelf A has been overwritten.");
                    }
                    break;

                    case 'B': {
                        shelfB = shelf.clone();
                        System.out.println("Shelf B has been overwritten.");
                    }
                    break;

                    case 'C': {
                        shelfC = shelf.clone();
                        System.out.println("Shelf C has been overwritten.");
                    }
                    break;

                    default: {
                        System.out.println("Invalid shelf. Please start over. "
                                + "Sorry for the inconvenience!");
                    }
                }

                end();
            }
            break;

            case 'E': {
                Bookshelf shelf1 = new Bookshelf();
                Bookshelf shelf2 = new Bookshelf();

                System.out.print("Please select a shelf: ");
                String name1 = sc.next().toUpperCase();

                char iName1 = name1.charAt(0);

                switch (iName1) {
                    case 'A':
                        shelf1 = shelfA;
                        break;
                    case 'B':
                        shelf1 = shelfB;
                        break;
                    case 'C':
                        shelf1 = shelfC;
                        break;
                    default: {
                        System.out.println("\nInvalid shelf. Please start over. "
                                + " Sorry for the inconvenience!\n");

                        selectOption(shelf);
                    }
                }

                System.out.print("Please select another shelf: ");
                String name2 = sc.next().toUpperCase();

                char iName2 = name2.charAt(0);

                switch (iName2) {
                    case 'A':
                        shelf2 = shelfA;
                        break;
                    case 'B':
                        shelf2 = shelfB;
                        break;
                    case 'C':
                        shelf2 = shelfC;
                        break;
                    default: {
                        System.out.println("\nInvalid shelf. Please start over. "
                                + "Sorry for the inconvenience!\n");
                    }
                }

                if (shelf1.equals(shelf2)) {
                    System.out.println("These shelves are equal.");
                } else {
                    System.out.println("These shelves are not equal.");
                }

                end();
            }
            break;

            case 'P': {
                System.out.printf(shelf.toString());

                end();
            }
            break;

            case 'Q': {
                System.out.println("Goodbye!");
            }
            break;

            default: {
                System.out.println("Invalid option! Please try again with a "
                        + "different option.\n");

                selectOption(shelf);
            }
        }
    }

    /**
     * Runs at the end of every method to ask the user if more tasks need to be
     * carried out.
     *
     * @throws Exception Indicates if something in the chooseShelf() method goes
     * wrong.
     */
    public static void end() throws Exception {
        System.out.print("\nWould you like to carry out another task? (Y/N): ");
        String option = sc.next();

        char iOption = option.toUpperCase().charAt(0);

        if (iOption == 'Y') {
            System.out.print("\nWithin which shelf would you like to "
                    + "carry out the other task?: ");

            chooseShelf();
        } else if (iOption == 'N') {
            System.out.println("It was great working with you! Have a pleasant day!");
        } else {
            System.out.println("Incorrect input! Please try again.");
            end();
        }
    }
}
