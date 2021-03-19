package dev.wan.repos;

import dev.wan.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component // please read this class and use it to make beans
@Repository // Stereotype saying this class/interface is used to save data
// <entity, type of primary key>
public interface BookRepo extends CrudRepository<Book, Integer> {

    // Spring DATA abstract methods
    // You can define extra methods for your repos
    // Spring DATA will autocreate the implementation for it
    // Must follow spring data naming conventions for Spring
    Set<Book> findBooksByBookCondition(int book_condition);

    Set<Book> findByAuthorLike(String author);
}
