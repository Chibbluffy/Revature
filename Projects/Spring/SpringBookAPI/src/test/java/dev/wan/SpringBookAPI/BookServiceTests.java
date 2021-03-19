package dev.wan.SpringBookAPI;

import dev.wan.entities.Book;
import dev.wan.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    public void get_all_books(){
        Set<Book> books = bookService.getAllBooks();
        System.out.println(books);
    }
}
