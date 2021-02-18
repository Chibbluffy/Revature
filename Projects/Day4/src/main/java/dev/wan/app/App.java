package dev.wan.app;

import dev.wan.controllers.BookController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        BookController bookController = new BookController();

        // GET /books => return all books
        // GET /books?titleContains=Harry => only returns books containing that title
        app.get("/books", bookController.getAllBooksHandler);

        // GET /books/12 => return book of id 12
        app.get("/books/:id", bookController.getBookByIdHandler);

        // POST /books => create a new book
        app.post("/books", bookController.createBookHandler);

        // PUT /books/12 => update book 12
        app.put("/books/:id", bookController.updateBookHandler);

        // DELETE /books/12 => delete book 12
        app.delete("/books/:id", bookController.deleteBookHandler);


        // starts the webserver
        app.start();
    }
}
