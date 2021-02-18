package dev.wan.services;

import dev.wan.daos.BookDAO;
import dev.wan.entities.Book;

import java.util.HashSet;
import java.util.Set;

public class BookServiceImpl implements BookService{

    // Our service needs a dao to get and save books
    // BookDAO is a dependency
    // Our service will use a DAO to save things
    private static BookDAO bdao;
    public BookServiceImpl(BookDAO bdao){
        // This is a  dependency injection
        // Service created by passing in dependencies it needs
        this.bdao = bdao;
    }

    @Override
    public Book registerBook(Book book) {
        book.setAvailable(true);
        book.setDueDate(0);
        this.bdao.createBook(book);
        return book;
    }

    @Override
    public Set<Book> getAllBooks() {
        return this.bdao.getAllBooks();
    }

    @Override
    public Set<Book> getBooksByTitle(String title) {
        Set<Book> allBooks = this.getAllBooks();
        Set<Book> selectedBooks = new HashSet<Book>();
        for(Book b: allBooks){
            if(b.getTitle().toLowerCase().contains(title.toLowerCase())){
                selectedBooks.add(b);
            }
        }
        return selectedBooks;
    }

    @Override
    public Book getBookById(int id) {
        return this.bdao.getBookById(id);
    }

    @Override
    public Book updateBook(Book book) {
        // You have complete access to DAO methods. PLEASE USE them
        Book oldBook = this.bdao.getBookById(book.getBookId());
        if (oldBook.isAvailable() == true && book.isAvailable() == false){
            // check if book is checked out
            book.setDueDate(System.currentTimeMillis()/1000+604_800);
        }
        else if (oldBook.isAvailable() == false && book.isAvailable() == true){
            // check if book is checked out
            book.setDueDate(0);
        }
        this.bdao.updateBook(book);
        return book;
    }

    @Override
    public boolean deleteBookById(int id) {
        return this.bdao.deleteBookById(id);
    }
}
