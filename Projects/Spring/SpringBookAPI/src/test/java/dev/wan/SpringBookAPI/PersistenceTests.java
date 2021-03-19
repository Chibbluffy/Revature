package dev.wan.SpringBookAPI;

import dev.wan.entities.Book;
import dev.wan.repos.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // will automatically rollback any changes your tests make to the database
// will rollback after each test
public class PersistenceTests {
    @Autowired
    BookRepo bookRepo;

    @Test
    @Rollback
    public void create_book_test(){
        Book book = new Book();
        bookRepo.save(book);
        System.out.println(book);
    }

    @Test
    @Commit
    public void create_book_persist(){
        Book book = new Book();
        bookRepo.save(book);
        System.out.println(book);
    }
}
