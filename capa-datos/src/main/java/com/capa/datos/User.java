package com.capa.datos;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final String email;
    private final String password;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String username, String email, String password, List<Book> borrowedBooks) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

   public boolean borrowBookIfAvailable(Book book) {
        if (book == null) {
            return false;
        }
        if (!book.isAvailable()) {
            return false;
        }
        if (borrowedBooks.contains(book)) {
            return false;
        }
        borrowedBooks.add(book);
        book.setAvailable(false);
        return true;
    }

    public boolean returnBorrowedBook(Book book){
        if (book == null) {
            return false;
        }
        boolean removed = borrowedBooks.remove(book);
        if (removed){
            book.returnBook();
        }
        return removed;
    }

    public List<Book> getBorrowedBooksSnapshot() {
        return new ArrayList<>(borrowedBooks);
    }
}
