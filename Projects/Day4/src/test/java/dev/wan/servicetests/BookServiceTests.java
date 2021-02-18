package dev.wan.servicetests;

import dev.wan.daos.BookDaoLocal;
import dev.wan.entities.Book;
import dev.wan.services.BookService;
import dev.wan.services.BookServiceImpl;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTests {
    private static BookService bs = new BookServiceImpl(new BookDaoLocal());
    private static Book testbook = null;

    @Test
    @Order(1)
    void register_book(){
        Book book = new Book(0,"Harry Potter", "JK", 3, false, 0);
        bs.registerBook(book); // Service is performing book validation and upkeep
                                // This validation is business logic that applies only to the community library (BookServiceImpl)
        System.out.println(book);

        testbook = book;
        Assertions.assertNotEquals(0, book.getBookId());
        Assertions.assertTrue(book.isAvailable());
    }

    // People are given a week to return a book.
    // When you check out a book,
        // available is set to false,
        // return date also updated
    @Test
    @Order(2)
    void update_book_checkout(){
        // Book book = bs.getBookById(testbook.getBookId());
        Book book = new Book(testbook.getBookId(), "Harry Potter", "JK", 3, false, 0);
        bs.updateBook(book); //

        // return date should be 7 days in the future when you update the book
        // 604_800 seconds in a week
        System.out.println(book);
        Assertions.assertEquals(System.currentTimeMillis()/1000+604_800, book.getDueDate(), 100);
    }

}
