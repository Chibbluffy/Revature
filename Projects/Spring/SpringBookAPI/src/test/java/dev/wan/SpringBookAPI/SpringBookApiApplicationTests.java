package dev.wan.SpringBookAPI;

import dev.wan.entities.Book;
import dev.wan.repos.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest // Create an application context and all the beans in it BEFORE you run your tests
class SpringBookApiApplicationTests {

	@Autowired // Tells Spring you need a bean of this type
	// Spring DATA will read your interfaces and autogenerate implementation classes
	BookRepo bookRepo;

	@Test
	void create_book() {
		Book book = new Book(0, "To Kill a Mockingbird", "Harper Lee", 1, true, 0);
		bookRepo.save(book);
		System.out.println(book);
	}

	@Test
	void get_book_by_id() {
		// findby in Spring DATA returns an "optional"
		// similar to a promise
		Book book = bookRepo.findById(10).get();
		System.out.println(book);
	}

	@Test
	void get_book_by_condition() {
		// findby in Spring DATA returns an "optional"
		// similar to a promise
		Set<Book> books = bookRepo.findBooksByBookCondition(1);
		System.out.println(books);
	}

	@Test
	void get_book_by_author() {
		// findby in Spring DATA returns an "optional"
		// similar to a promise
		Set<Book> books = bookRepo.findByAuthorLike("Tom");
		System.out.println(books);
	}

}
