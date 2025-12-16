package com.capa.datos;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private final String firstName;
    private final String lastName;
    private final String biography;
    private List<Book> publishedBooks = new ArrayList<>();

    public Author(String firstName, String lastName, String biography, List<Book> publishedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publishedBooks = publishedBooks;
    }

    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    public List<Book> getPublishedBooks() {
        return new ArrayList<>(publishedBooks);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addBook(Book book) {
        this.publishedBooks.add(book);
    }

   public String getReadableDetails() {
        StringBuilder summary = new StringBuilder();
        summary.append("Autor: ").append(getFullName()).append('\n');
        summary.append("Biografia: ").append(biography).append('\n');
        summary.append("Libros publicados:\n");
        if (publishedBooks.isEmpty()) {
            summary.append(" - Sin libros registrados\n");
        } else {
            for (Book book : publishedBooks) {
                summary.append(" - ").append(book.getReadableDetails()).append('\n');
            }
        }
        return summary.toString();
    }
}
