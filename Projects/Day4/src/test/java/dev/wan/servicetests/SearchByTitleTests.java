package dev.wan.servicetests;

import dev.wan.daos.BookDAO;
import dev.wan.entities.Book;
import dev.wan.services.BookService;
import dev.wan.services.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

// Mocking in tests
// A lot of times when testing, we have to assume certain values
//    or dependencies already works
// A service test would not pass if the DAO it uses do save things does not work
// Service logic could be fine, you can still get a failure
// Mocking fakes the return of a method, so you can continue testing
//    or working on a particular piece of functionality

@ExtendWith(MockitoExtension.class)
public class SearchByTitleTests {
    @Mock
    BookDAO bookDAO = null;

    private BookService bookService = null;

    @BeforeEach // this is a method that will run before each test
    void set_up(){
        Book greatGatsby = new Book(1, "The Great Gats", "F Scott", 1, true, 0);
        Book hp1 = new Book(2, "Harry Potter", "JK", 1, true, 0);
        Book hp2 = new Book(3, "Harrier Potter", "JK", 1, true, 0);
        Book hp3 = new Book(4, "Even Harrier Potter", "JK", 1, true, 0);
        Book hp4 = new Book(5, "Very Very Harry Potter", "JK", 1, true, 0);
        Book hp5 = new Book(6, "Harriest Potter", "JK", 1, true, 0);
         Set<Book> bookSet = new HashSet<Book>();
         bookSet.add(greatGatsby);
         bookSet.add(hp1);
         bookSet.add(hp2);
         bookSet.add(hp3);
         bookSet.add(hp4);
         bookSet.add(hp5);
         Mockito.when(bookDAO.getAllBooks()).thenReturn(bookSet);

         // mocking adds consistency to method calls
        this.bookService = new BookServiceImpl(this.bookDAO);
    }

    @Test
    void search_by_title(){
        System.out.println(this.bookDAO.getAllBooks());
        Set<Book> books = this.bookService.getBooksByTitle("Harr");
        Assertions.assertEquals(5, books.size());
    }

    @Test
    void search_by_title_case_insensitive(){
        System.out.println(this.bookDAO.getAllBooks());
        Set<Book> books = this.bookService.getBooksByTitle("HArR");
        Assertions.assertEquals(5, books.size());
    }
}
