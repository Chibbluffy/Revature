package dev.wan.services;

import dev.wan.entities.Book;

import java.util.Set;

// Most of the business logic for an application is in services
// Business logic is the implementation of application specific rules or features
// A service might also have methods that wrap around a dao class ande are fairly lean in business logic
public interface BookService {
    Book registerBook(Book book);

    Set<Book> getAllBooks();
    Set<Book> getBooksByTitle(String title);
    Book getBookById(int id);

    //
    Book updateBook(Book book);

    boolean deleteBookById(int id);

}
