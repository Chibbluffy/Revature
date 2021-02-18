package dev.wan.controllers;

import com.google.gson.Gson;
import dev.wan.daos.BookDaoLocal;
import dev.wan.entities.Book;
import dev.wan.services.BookService;
import dev.wan.services.BookServiceImpl;
import io.javalin.http.Handler;

import java.util.Set;

// All the logic in a controller should deal with the API
// Reading path parameters, etc
// Controllers should call services to perform actions
public class BookController {
    private BookService bookService = new BookServiceImpl(new BookDaoLocal());

    public Handler getAllBooksHandler = (ctx) -> {
        String titleContains = ctx.queryParam("titleContains", "NONE");
        if (titleContains.equals("NONE")) {
            Set<Book> allBooks = this.bookService.getAllBooks();
            Gson gson = new Gson();
            String booksJSON = gson.toJson(allBooks); // convert to JSON
            ctx.result(booksJSON);
            ctx.status(200); // how to set status code
        }
        else {
            Set<Book> books = this.bookService.getBooksByTitle(titleContains);
            Gson gson = new Gson();
            String selectedBooksJSON = gson.toJson(books);
            ctx.result(selectedBooksJSON);
        }
    };

    public Handler getBookByIdHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Book book = this.bookService.getBookById(id);
        Gson gson = new Gson();
        String bookJSON = gson.toJson((book));
        if (book == null){
            ctx.result("Book not found");
            ctx.status(404);
        }
        else{
            ctx.result(bookJSON);
        }
    };



    public Handler createBookHandler = (ctx) -> {
        String bookJSON = ctx.body();
        Gson gson = new Gson();
        Book book = gson.fromJson(bookJSON, Book.class);
        this.bookService.registerBook(book);
        ctx.result("Book was created: \n" + bookJSON);
        ctx.status(201);
    };

    // PUT /books/20 => updates book number
    public Handler updateBookHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String body = ctx.body();
        Gson gson = new Gson();
        Book book = gson.fromJson(body, Book.class);
        book.setBookId(id);
        this.bookService.updateBook(book);
        ctx.result("Book was updated");
    };

    public Handler deleteBookHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.bookService.deleteBookById(id);
        if (deleted){
            ctx.result("Book " + id + " deleted:");
        }
        else {
            ctx.result("Book " + id + " was NOT deleted");
        }
    };

}
