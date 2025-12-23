package com.capa.datos;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> registeredBooks = new ArrayList<>();
    private final List<User> registeredUsers = new ArrayList<>();

    /**
     * Registra un libro en la biblioteca si todavía no había sido agregado.
     */
    public void registerBook(Book book) {
        if (book == null) {
            return;
        }
        if (!registeredBooks.contains(book)) {
            registeredBooks.add(book);
        }
    }

    /**
     * Registra un usuario en la biblioteca cuando no existe ya uno con el mismo correo.
     */
    public void registerUser(User user) {
        if (user == null) {
            return;
        }
        for (User existingUser : registeredUsers) {
            if (existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                return;
            }
        }
        registeredUsers.add(user);
    }

    /**
     * Busca un libro por su ISBN y devuelve la referencia encontrada o {@code null} si no existe.
     */
    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        if (isbn == null) {
            return null;
        }
        for (Book book : registeredBooks) {
            if (isbn.equalsIgnoreCase(book.getIsbn())) {
                return book;
            }
        }
        //return null;
        throw new BookNotFoundException("El libro con isbn:  " + isbn + "no se encuentra." );
    }

    /**
     * Devuelve una copia de los libros registrados para que el llamador pueda iterar con seguridad.
     */
    public List<Book> getBooksSnapshot() {
        return new ArrayList<>(registeredBooks);
    }

    /**
     * Entrega una copia de los usuarios registrados, útil para mostrar la información en pantalla.
     */
    public List<User> getUsersSnapshot() {
        return new ArrayList<>(registeredUsers);
    }

    /**
     * Busca un usuario por correo electrónico. Se utiliza un ciclo simple para mantener el ejemplo accesible.
     */
    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        for (User user : registeredUsers) {
            if (email.equalsIgnoreCase(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}
