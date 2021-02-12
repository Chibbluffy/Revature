package dev.wan.daotests;

import dev.wan.daos.BookDAO;
import dev.wan.daos.BookDaoLocal;
import dev.wan.entities.Book;
import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.logging.Logger;

// Unless specifically use annotation to specify order, they will not run in a pre-determined way
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoTest {
    private static BookDAO bdao = new BookDaoLocal();

    private static Book testBook = null;
    private static Logger logger = Logger.getLogger(BookDaoTest.class);
//    class c = String.class;

    @Test
    @Order(1)
    void createBookTest(){
        // Any time a book has a ID of zero, it means that it is not saved or persisted anywhere
        // This is just a convention^
        Book book1 = new Book(0, "Tom's autobiography", "Tom", 2, true, 0);
        bdao.createBook(book1); // save or persist
        System.out.println(book1); // the id should not be zero

        Book book2 = new Book(0, "Not Tom's Bio", "Tom", 2, true, 0);
        bdao.createBook(book2);
        System.out.println(book2);

        testBook = book1;
        Assertions.assertNotEquals(0, book1.getBookId());
        Assertions.assertNotEquals(0, book2.getBookId());

        logger.info("creating book test");
    }

    @Test
    @Order(2)
    void get_book_by_id(){
        int id = testBook.getBookId();
        Book book = bdao.getBookById(id);
        Assertions.assertEquals(testBook.getTitle(), book.getTitle());


    }

    @Test
    @Order(3)
    void update_book(){
        Book b = bdao.getBookById(testBook.getBookId());
        b.setCondition(3);
        bdao.updateBook(b); // should update book to have worse condition

        Book updatedBook = bdao.getBookById(testBook.getBookId());
        Assertions.assertEquals(3, updatedBook.getCondition());
    }

    @Test
    @Order(4)
    void get_all_books(){
        Book b1 = new Book(0, "Outsiders", "S.E. Hinton", 1, true, 1);
        Book b2 = new Book(1, "One Flew Over the Cuckoo's Nest", "Ken Kesey", 1, true, 0);
        Book b3 = new Book(0, "Christmas Carol", "Charles Dickens", 1, true, 0);

        bdao.createBook(b1);
        bdao.createBook(b2);
        bdao.createBook(b3);

        Set<Book> allBooks = bdao.getAllBooks();
        Assertions.assertTrue(allBooks.size() > 2);
    }

    @Test
    @Order(5)
    void delete_book_by_id(){
        int id = testBook.getBookId();
        boolean result = bdao.deleteBookById(id);
        Assertions.assertTrue(result);
    }
}
