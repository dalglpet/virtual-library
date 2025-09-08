package main;

public class Book
{
    // Each book stores its ISBN, title, author, genre, and publication year
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    // Constructor
    public Book(String isbn, String title, String author, String genre, int publicationYear)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getPublicationYear()
    {
        return publicationYear;
    }

    // Convert a book into a readable string
    public String toString()
    {
        return "[" + isbn + "] \"" + title + "\" by " + author + ", " + genre + ", " + publicationYear;
    }
}
