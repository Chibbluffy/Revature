package dev.wan.hibernatetests;

import dev.wan.entities.Book;
import dev.wan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class BasicHibernateTests {
    @Test
    void create_book(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession(); // the session interface is used to perform operations
        // ideally you will use session to create transactions so that you could rollback any errors
        // easily in Java
        
        sess.getTransaction().begin();

        Book b = new Book(0,"Great Gatsby", "F SCOT FITZ", 1, true,0);
        sess.save(b);
        sess.getTransaction().commit();



    }
}
