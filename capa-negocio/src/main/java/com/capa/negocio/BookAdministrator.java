package com.capa.negocio;

import com.capa.datos.Book;
import com.capa.datos.User;

public class BookAdministrator{
    public boolean borrowBookProcess(Book book, User user){
        if(book == null || user == null){
            System.out.println("Libro o usuario no válido.");
            return false;
        }
        if (!book.isAvailable()){
            System.out.println("El libro '" + book.getTitle() + "' ya está prestado.");
            return false;
        }
        boolean registered = user.borrowBookIfAvailable(book);
        if (!registered){
            System.out.println("No se registró préstamo para: " + user.getUsername() + ".");
            return false;
        }
        System.out.println(user.getUsername() + " ha solicitado el libro: '" + book.getTitle() + "'");
        return true;
    }

    public String buildLoanReceipt(Book book, User user) {
        if (book == null || user == null) {
            return "No es posible generar comprobante: falta información.";
        }
        StringBuilder receipt = new StringBuilder();
        receipt.append("Comprobante de préstamo\n");
        receipt.append("Usuario: ").append(user.getUsername()).append('\n');
        receipt.append("Libro entregado: ").append(book.getReadableDetails()).append('\n');
        receipt.append("Libros actualmente prestados al usuario:\n");
        for (Book borrowed : user.getBorrowedBooksSnapshot()) {
            receipt.append(" - ").append(borrowed.getReadableDetails()).append('\n');
        }
        return receipt.toString();
    }
}
