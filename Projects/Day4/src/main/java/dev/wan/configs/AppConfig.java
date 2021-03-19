package dev.wan.configs;

import dev.wan.controllers.BookController;
import dev.wan.daos.BookDAO;
import dev.wan.daos.BookDaoHibernate;
import dev.wan.daos.BookDaoLocal;
import dev.wan.services.BookService;
import dev.wan.services.BookServiceImpl;
import io.javalin.Javalin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {

    @Bean(name = "noCorsApp")
    public Javalin openApp(){
        Javalin app = Javalin.create(cfg->{
            cfg.enableCorsForAllOrigins();
        });
        return app;
    }

    @Bean(name = "Cors")
    public Javalin corsApp(){
        Javalin app = Javalin.create();
        return app;
    }

    @Bean(name = "LocalBookController")
    public BookController localApp(){
        BookDAO bd = new BookDaoLocal();
        BookService bs = new BookServiceImpl(bd);
        BookController bookController = new BookController(bs);
        return bookController;
    }

    @Bean(name = "DatabaseController")
    public BookController databaseApp(){
        BookDAO bd = new BookDaoHibernate();
        BookService bs = new BookServiceImpl(bd);
        BookController bookController = new BookController(bs);
        return bookController;
    }
}
