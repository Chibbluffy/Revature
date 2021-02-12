package dev.wan.daos;

import dev.wan.entities.Book;

import java.util.Set;

// Every entity will have it's own DAO
// DAO (Data Access Object) is a class designed to perform CRUD operations for a single entity
// Create, Read, Update, Delete
public interface BookDAO {

    // Create
    Book createBook(Book book);

    // Read
    Set<Book> getAllBooks();
    Book getBookById(int id);

    // Update
    Book updateBook(Book book);

    // Delete
    boolean deleteBookById(int id);

}
