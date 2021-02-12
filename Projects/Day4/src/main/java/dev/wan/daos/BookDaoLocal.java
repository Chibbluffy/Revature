package dev.wan.daos;

import dev.wan.entities.Book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// local in memory "database"
public class BookDaoLocal implements BookDAO{

    private static Map<Integer,Book> bookTable = new HashMap<Integer,Book>();
    private static int idMaker = 0;

    @Override
    public Book createBook(Book book) {
        book.setBookId(++idMaker); // creates new and unique id for book. Most programs just use a counter
        bookTable.put(book.getBookId(),book); // emulates saving to SQL database

        return book;
    }

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> allBooks = new HashSet<Book>(bookTable.values());
        return allBooks;
    }

    @Override
    public Book getBookById(int id) {
        return bookTable.get(id);
    }

    @Override
    public Book updateBook(Book book) {
        return bookTable.put(book.getBookId(), book);
    }

    @Override
    public boolean deleteBookById(int id) {
        Book book = bookTable.remove(id);// This removed the object but also returns object that was removed
        if (book == null){
            return false;
        }
        return true;
    }
}
