package dev.wan.controllers;

import dev.wan.aspects.Authorized;
import dev.wan.entities.Book;
import dev.wan.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Component
//@Controller // Tells Spring tho read the methods in this class to generate a controller bean
// @Controller by default is designed to return a view, and not a JSON string
// From a holdover of Spring being used for server side rendering
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // Spring will create a get route using this path
    // Spring will automatically convert any returns to JSON for you
    @GetMapping("/books")
    @ResponseBody
    @Authorized
    public Set<Book> retrieveAllBooks(){
        Set<Book> books = this.bookService.getAllBooks();
        return books;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    @Authorized
    public Book getBookById(@PathVariable int id){
        Book book = this.bookService.getBookById(id);
        if (book == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Actor Not Found");
        }
        return book;
    }

    @PostMapping("/books")
    @ResponseBody
    @Authorized
    public Book createBook(@RequestBody Book book){
        // @RequestBody Spring will automatically convert input JSON to Java obj
        this.bookService.registerBook(book);
        return book;
    }

    @PutMapping("/books/{id}")
    @ResponseBody
    @Authorized
    public Book updateBook(@PathVariable int id, @RequestBody Book book){
        book.setBookId(id);
        this.bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    @ResponseBody
    @Authorized
    public boolean deleteBookById(@PathVariable int id){
        // @RequestParam("param") for queryparams
        boolean result = this.bookService.deleteBookById(id);
        return result;
    }



}
