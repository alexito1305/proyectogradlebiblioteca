package com.capa.negocio;

import com.capa.datos.Author;
import com.capa.datos.Book;

public class AuthorInfo {
      public Author createFeaturedAuthor() {
            Author author = new Author("Gabriel", "García Márquez", "Colombiano, referente de la literatura latinoamericana");
            String authorName = author.getFullName();
            author.addBook(Book.createAvailableBook("Cien Años de Soledad", authorName, 1967, "6070728793"));
            author.addBook(Book.createAvailableBook("El coronel no tiene quien le escriba", authorName, 1961, "6070728742"));
            author.addBook(Book.createAvailableBook("El amor en tiempos de cólera", authorName, 1985, "6070796195"));
            return author;
        }

        public String buildAuthorSummary(Author author) {
            if (author == null) {
                return "No se proporcionó información de autor.";
            }
            return author.getReadableDetails();
        }
}

