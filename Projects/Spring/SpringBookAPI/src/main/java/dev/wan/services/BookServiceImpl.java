package dev.wan.services;

import dev.wan.entities.Book;
import dev.wan.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class BookServiceImpl implements BookService {

    @Autowired // Spring will inject a bean of this interface
    BookRepo bookRepo;

    @Override
    public Book registerBook(Book book) {
        this.bookRepo.save(book);
        return book;
    }

    @Override
    public Book getBookById(int id) {

        return this.bookRepo.findById(id).get();
    }

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> books = new HashSet<>((Collection<? extends Book>) this.bookRepo.findAll());
        return books;
    }

    @Override
    public Book updateBook(Book book) {
        this.bookRepo.save(book);
        // there is no specific update
        // save is basically overwrite
        return book;
    }

    @Override
    public boolean deleteBookById(int id) {
        this.bookRepo.deleteById(id);
        return true;
    }
}
