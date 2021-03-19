package dev.wan.services;

import dev.wan.entities.Book;
import dev.wan.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface BookService {

    // CREATE
    Book registerBook(Book book);

    // READ
    Book getBookById(int id);
    Set<Book> getAllBooks();

    // UPDATE
    Book updateBook(Book book);

    // DELETE
    boolean deleteBookById(int id);

}
