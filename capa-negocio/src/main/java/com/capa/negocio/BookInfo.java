package com.capa.negocio;

import com.capa.datos.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {
    public List<Book> buildSampleCatalog() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(Book.createAvailableBook("El conde de Montecristo", "Alejandro Dumas", 2014, "8494277863"));
        bookList.add(Book.createAvailableBook("1984", "George Orwell", 1949, "0451524935"));
        bookList.add(Book.createAvailableBook("El Quijote de la Mancha", "Miguel de Cervantes", 1605, "8424117585"));
        return bookList;
    }

    public String buildCatalogSummary(List<Book> catalog) {
        StringBuilder summary = new StringBuilder();
        summary.append("Libros disponibles en la biblioteca:\n");
        if (catalog == null || catalog.isEmpty()) {
            summary.append(" - No hay libros registrados\n");
            return summary.toString();
        }
        for (Book book : catalog) {
            summary.append(" - ").append(book.getReadableDetails()).append('\n');
        }
        return summary.toString();
    }

    public Book findByIsbn(List<Book> catalog, String isbn) {
           if (catalog == null || isbn == null) {
                return null;
            }
            for (Book book : catalog) {
                if (isbn.equalsIgnoreCase(book.getIsbn())) {
                    return book;
                }
            }return null;
    }
}


