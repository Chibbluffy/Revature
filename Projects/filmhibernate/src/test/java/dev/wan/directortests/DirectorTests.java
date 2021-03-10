package dev.wan.directortests;

import dev.wan.entities.Director;
import dev.wan.entities.Movie;
import dev.wan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


// states of an object in Hibernate
// 1. transient
// 2. persistent
// 3. detached

public class DirectorTests {

    // an object with an ID 0 is not saved into database yet
    // it is considered transient

    // once object is saved and has an ID, a non-0 ID
    // the object is now considered persistent

    // Once the session is closed, any object that was saved/modified
    // the object is considered detached
    @Test
    void create_director(){
        Director director = new Director(0,"Tom", "Wan");
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(director);
        sess.getTransaction().commit();
        sess.close();

        System.out.println(director);
        Assertions.assertTrue(director.getDirectorId() > 0);

    }

    @Test
    void get_director(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Director director = sess.get(Director.class, 1);
        System.out.println(director);
        System.out.println(director.getMovies());
        sess.close();
    }
    // In hibernate, we can lazy fetch or eager fetch
    // eager fetch means that when we get an object, all nested objects are selected and returned immediately
    // one giant select statement

    // lazy fetch does not get all movies until you do director.getMovies

    @Test
    void eager_get_director(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Director director = sess.get(Director.class, 1);
        System.out.println(director);
        System.out.println(director.getMovies()); // movies set is not populated until it is called for in lazy fetch
        sess.close();
        System.out.println(director.getMovies()); // if you did this after sess.close without calling it inside, you get an exception
        // by default, hibernate assumes nested objects to be lazy loaded.
    }

    @Test
    void lazy_get_director(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Director director = sess.get(Director.class, 1);
        System.out.println(director);
        System.out.println(director.getMovies()); // movies set is not populated until it is called for in lazy fetch
        sess.close();
        System.out.println(director.getMovies()); // if you did this after sess.close without calling it inside, you get an exception
        // by default, hibernate assumes nested objects to be lazy loaded.

        // when you lazy load, the object you return is called a proxy object
        // because it does not have everything in it already
    }

    @Test
    void cascading(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        Director director = sess.get(Director.class, 1);
        Movie movie = new Movie(0, "Shining", 100, 1);
        director.getMovies().add(movie);
        sess.update(director);
        // do not have to save movie directly into a table
        // hibernate can see that there is a new movie and will act accordingly

        sess.getTransaction().commit();
        sess.close();
    }

    // Hibernate provides 3 ways for you to make queries
    // 1. criteria API (very OOP centric)
    // 2. HQL (Hibernate Query Language)
    // 3. Native SQL (avoid if possible)



}
