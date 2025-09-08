
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Create an empty library object to hold books
        Library library = new Library();

        // Sample data
        library.addBook(new Book("9780441172719", "Dune", "Frank Herbert", "Science Fiction", 1965));
        library.addBook(new Book("9780765330345", "A Dog's Purpose", "W. Bruce Cameron", "Fiction", 2010));
        library.addBook(new Book("9780689840920", "Hatchet", "Gary Paulsen", "Adventure", 1987));
        library.addBook(new Book("9780547928227", "The Hobbit", "J. R. R. Tolkien", "Fantasy", 1937));
        library.addBook(new Book("9780553280909", "Hondo", "Louis L'Amour", "Western", 1953));
        library.addBook(new Book("9780553051827", "The Haunted Mesa", "Louis L'Amour", "Western", 1987));
        library.addBook(new Book("9780590353427", "Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "Fantasy", 1997));

        // Run the main menu loop until the user chooses to exit
        while (true) {
            printMenu(); // display the main menu options
            String choice = prompt("Choose an option"); // get user input
            switch (choice) {
                case "1":
                    // Add a new book by prompting the user for each field
                    addBookInteractively(library);
                    break;
                case "2":
                    // Search the library by ISBN, title, author, or genre
                    searchMenu(library);
                    break;
                case "3":
                    // Display all books currently in the library
                    listAll(library);
                    break;
                case "4":
                    // Show books sorted by year and author last name
                    showSorts(library);
                    break;
                case "0":
                    // Exit the program
                    System.out.println("Goodbye!");
                    return;
                default:
                    // Handle invalid menu options
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    // Print the main menu options to the console
    private static void printMenu() {
        System.out.println("\n=== Library Menu ===");
        System.out.println("1) Add a book manually");
        System.out.println("2) Search books");
        System.out.println("3) List all books");
        System.out.println("4) View sorted lists");
        System.out.println("0) Exit");
    }

    // Prompt the user for book details and add it to the library
    private static void addBookInteractively(Library library) {
        System.out.println("\n-- Add a Book --");
        String isbn   = prompt("ISBN");
        String title  = prompt("Title");
        String author = prompt("Author");
        String genre  = prompt("Genre");

        int year;
        while (true) {
            String yearStr = prompt("Publication year (integer)");
            try {
                year = Integer.parseInt(yearStr.trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer year.");
            }
        }

        // Create the book object and add it to the library
        Book b = new Book(isbn, title, author, genre, year);
        library.addBook(b);
        System.out.println("Added: " + b);
    }

    // Display a submenu for searching books by different criteria
    private static void searchMenu(Library library) {
        System.out.println("\n-- Search Menu --");
        System.out.println("1) By ISBN");
        System.out.println("2) By Title (contains)");
        System.out.println("3) By Author (exact)");
        System.out.println("4) By Genre (exact)");
        String choice = prompt("Choose a search type");

        switch (choice) {
            case "1": {
                // Search by ISBN
                String isbn = prompt("Enter ISBN");
                Book result = library.findByIsbn(isbn);
                if (result != null) {
                    System.out.println("Found:\n" + result);
                } else {
                    System.out.println("No book found with ISBN " + isbn);
                }
                break;
            }
            case "2": {
                // Search by title keyword(s)
                String q = prompt("Enter title keyword(s)");
                List<Book> results = library.findByTitle(q);
                printBooks(results);
                break;
            }
            case "3": {
                // Search by author
                String q = prompt("Enter author (exact name)");
                List<Book> results = library.findByAuthor(q);
                printBooks(results);
                break;
            }
            case "4": {
                // Search by genre
                String q = prompt("Enter genre (exact)");
                List<Book> results = library.findByGenre(q);
                printBooks(results);
                break;
            }
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Display all books currently in the library
    private static void listAll(Library library) {
        System.out.println("\n-- All Books --");
        List<Book> all = library.findByTitle(""); 
        printBooks(all);
    }

    // Show the library contents sorted by year and author last name
    private static void showSorts(Library library) {
        System.out.println("\n-- Sorted by Publication Year (Selection Sort) --");
        printBooks(library.sortedByPublicationYear());

        System.out.println("\n-- Sorted by Author Last Name (Insertion Sort) --");
        printBooks(library.sortedByAuthorLastName());
    }

    // Prompt the user with a label and return their input
    private static String prompt(String label) {
        System.out.print(label + ": ");
        return sc.nextLine();
    }

    // Utility method to print a list of books or a message if empty
    private static void printBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("(no results)");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
