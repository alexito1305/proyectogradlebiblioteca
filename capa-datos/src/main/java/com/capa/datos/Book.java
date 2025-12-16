package com.capa.datos;

public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;
    private final String isbn;
    private boolean available;

    public Book(String title, String author, int publicationYear, String isbn, boolean available) {
        this(title, author, publicationYear, isbn);
        this.available = available;
    }

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public static Book createAvailableBook(String title, String author, int publicationYear, String isbn) {
        Book book = new Book(title, author, publicationYear, isbn, true);
        return book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void returnBook() {
        this.available = true;
    }

    public String getReadableDetails() {
        String availabilityText = available ? "Disponible" : "Prestado";
        return String.format("%s (%d) - %s | ISBN: %s | %s", title, publicationYear, author, isbn, availabilityText);
    }
}

