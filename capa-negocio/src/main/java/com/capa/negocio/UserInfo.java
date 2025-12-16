package com.capa.negocio;

import com.capa.datos.Book;
import com.capa.datos.User;

import java.util.List;

public class UserInfo {
    public User createDefaultUser() {
        return new User("Alejandro", "shaggy1305@gmail.com", "BlaBla3");
    }

    public String buildUserSummary(User user) {
        if (user == null) {
            return "No se proporcionó información de usuario.";
        }
        StringBuilder summary = new StringBuilder();
        summary.append("Usuario: ").append(user.getUsername()).append('\n');
        summary.append("Email: ").append(user.getEmail()).append('\n');
        summary.append("Libros prestados:\n");
        List<Book> borrowedBooks = user.getBorrowedBooksSnapshot();
        for (Book book : borrowedBooks) {
            summary.append(" - ").append(book.getReadableDetails()).append('\n');
        }
        if (borrowedBooks.isEmpty()) {
            summary.append(" - Sin préstamos registrados\n");
        }
        return summary.toString();
    }

}



