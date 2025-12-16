package com.proyecto.gradle;

import com.capa.datos.Author;
import com.capa.datos.Book;
import com.capa.datos.Library;
import com.capa.datos.User;
import com.capa.negocio.AuthorInfo;
import com.capa.negocio.BookAdministrator;
import com.capa.negocio.BookInfo;
import com.capa.negocio.UserInfo;

import java.util.List;

public class HeadClass {
    public static void main(String[] args) {
        //Carga de libros a la lista
        BookInfo bookInfo = new BookInfo();
        List<Book> catalog = bookInfo.buildSampleCatalog();

        //Se registran los libros en biblioteca y se genera catálogo
        Library library = new Library();
        for (Book book : catalog){
            library.registerBook(book);
        }
        System.out.println("-----------------");
        System.out.println(bookInfo.buildCatalogSummary(library.getBooksSnapshot()));

        //Generamos autor y desplegamos su información
        AuthorInfo authorInfo = new AuthorInfo();
        Author author = authorInfo.createFeaturedAuthor();
        System.out.println("-----------------");
        System.out.println(authorInfo.buildAuthorSummary(author));

        //Se crea usuario y se despliega su información
        UserInfo userInfo = new UserInfo();
        User user = userInfo.createDefaultUser();
        library.registerUser(user);
        System.out.println("-----------------");
        System.out.println(userInfo.buildUserSummary(user));

        // Intentamos registrar un préstamo de libro para el usuario
        BookAdministrator bookAdmin = new BookAdministrator();
        // Buscamos un libro específico por su ISBN (O bien por algún otro dato, esta funcionalidad se podría extender) para el préstamo
        Book bookToBorrow = library.findBookByIsbn("0451524935");
        // Procesamos el préstamo y mostramos el comprobante si fue exitoso
        boolean loanRegistered = bookAdmin.borrowBookProcess(bookToBorrow, user);
        // Por último mostramos el comprobante del préstamo
        if (loanRegistered) {
            System.out.println("-----------------");
            System.out.println(bookAdmin.buildLoanReceipt(bookToBorrow, user));
        } else {
            System.out.println("No fue posible registrar el préstamo solicitado.");
        }
    }
}
