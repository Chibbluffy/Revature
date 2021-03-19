package dev.wan.app;

import dev.wan.configs.AppConfig;
import dev.wan.controllers.BookController;
import dev.wan.controllers.LoginController;
import io.javalin.Javalin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        Javalin app = Javalin.create(
////                javalinConfig -> {
////                    javalinConfig.enableCorsForAllOrigins();
////                },
//                config -> {
//                    config.enableCorsForAllOrigins();// allows the server to process JS requests from anywhere
//                }
//        );

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Javalin app = ac.getBean("noCors", Javalin.class);
        BookController bookController = new BookController();
        LoginController loginController = new LoginController();

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

        // POST /users/login
        // login controller
        app.post("/users/login", loginController.loginHandler);

        // starts the webserver
        app.start();
    }
}
