package main;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    // List that stores all books in the library
    private List<Book> bookList;

    // Constructor (creates an empty list)
    public Library()
    {
        bookList = new ArrayList<Book>();
    }

    // Add a book to the library
    public void addBook(Book book)
    {
        bookList.add(book);
    }

    // Find a book by ISBN using a linear search
    public Book findByIsbn(String isbn)
    {
        for (int i = 0; i < bookList.size(); i++)
        {
            Book currentBook = bookList.get(i);
            if (currentBook.getIsbn().equals(isbn))
            {
                return currentBook;
            }
        }
        return null;
    }

    // Find all books whose title contains the search term (case insensitive)
    public List<Book> findByTitle(String query)
    {
        List<Book> resultList = new ArrayList<Book>();
        String searchWord = toLowercase(query);

        for (int i = 0; i < bookList.size(); i++)
        {
            Book currentBook = bookList.get(i);
            String titleKey = toLowercase(currentBook.getTitle());
            if (titleKey.contains(searchWord))
            {
                resultList.add(currentBook);
            }
        }
        return resultList;
    }

    // Find all books written by the given author
    public List<Book> findByAuthor(String author)
    {
        List<Book> resultList = new ArrayList<Book>();
        String authorKey = toLowercase(author);

        for (int i = 0; i < bookList.size(); i++)
        {
            Book currentBook = bookList.get(i);
            String currentAuthorKey = toLowercase(currentBook.getAuthor());
            if (currentAuthorKey.equals(authorKey))
            {
                resultList.add(currentBook);
            }
        }
        return resultList;
    }

    // Find all books in a given genre (case insensitive, exact match)
    public List<Book> findByGenre(String genre)
    {
        List<Book> resultList = new ArrayList<Book>();
        String genreKey = toLowercase(genre);

        for (int i = 0; i < bookList.size(); i++)
        {
            Book currentBook = bookList.get(i);
            String currentGenreKey = toLowercase(currentBook.getGenre());
            if (currentGenreKey.equals(genreKey))
            {
                resultList.add(currentBook);
            }
        }
        return resultList;
    }

    // Sort books by publication year using selection sort
    public List<Book> sortedByPublicationYear()
    {
        List<Book> sorted = new ArrayList<Book>(bookList);

        for (int i = 0; i < sorted.size(); i++)
        {
            int minIndex = i;

            // Find the index of the book with the smallest year from i to end
            for (int j = i + 1; j < sorted.size(); j++)
            {
                int yearAtMin = sorted.get(minIndex).getPublicationYear();
                int yearAtJ = sorted.get(j).getPublicationYear();

                if (yearAtJ < yearAtMin)
                {
                    minIndex = j;
                }
            }

            // Swap book at i with book at minIndex
            if (minIndex != i)
            {
                Book temp = sorted.get(i);
                sorted.set(i, sorted.get(minIndex));
                sorted.set(minIndex, temp);
            }
        }
        return sorted;
    }

    // Sort books by author last name using insertion sort
    public List<Book> sortedByAuthorLastName()
    {
        List<Book> sorted = new ArrayList<Book>(bookList);

        for (int i = 1; i < sorted.size(); i++)
        {
            Book keyBook = sorted.get(i);
            String keyLastName = lastNameOf(keyBook.getAuthor());
            int j = i - 1;

            // Shift books whose last name comes after the key
            while (j >= 0 && lastNameOf(sorted.get(j).getAuthor()).compareToIgnoreCase(keyLastName) > 0)
            {
                sorted.set(j + 1, sorted.get(j));
                j = j - 1;
            }

            // Insert keyBook into correct position
            sorted.set(j + 1, keyBook);
        }
        return sorted;
    }

    // Convert text to lowercase
    private String toLowercase(String text)
    {
        if (text == null)
        {
            return "";
        }
        return text.toLowerCase();
    }

    // Extract the last word of the author name as the last name
    private String lastNameOf(String author)
    {
        if (author == null)
        {
            return "";
        }

        String trimmed = author.trim();
        if (trimmed.length() == 0)
        {
            return "";
        }

        String[] parts = trimmed.split(" ");
        return parts[parts.length - 1];
    }
}
