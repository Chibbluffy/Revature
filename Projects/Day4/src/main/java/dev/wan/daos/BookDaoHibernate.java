package dev.wan.daos;

import dev.wan.entities.Book;
import dev.wan.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class BookDaoHibernate implements BookDAO{
    Logger logger = Logger.getLogger(BookDaoHibernate.class.getName());
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    @Override
    public Book createBook(Book book) {
        Session sess = sf.openSession();
        sess.getTransaction().begin();
        sess.save(book); // changes object to match the new one in database
        sess.getTransaction().commit();
        sess.close();
        return book;
    }

    @Override
    public Set<Book> getAllBooks() {

        return null;
    }

    @Override
    public Book getBookById(int id) {
        Session sess = sf.openSession();
        Book b = sess.get(Book.class, id);
        sess.close();
        return b;
    }

    @Override
    public Book updateBook(Book book) {
        Session sess = sf.openSession();
        sess.getTransaction().begin();
        sess.update(book); // changes object to match the new one in database
        sess.getTransaction().commit();
        sess.close();
        return book;
    }

    @Override
    public boolean deleteBookById(int id) {
        try{
            Session sess = sf.openSession();
            sess.getTransaction().begin();
            sess.delete(this.getBookById(id));
            sess.getTransaction().commit();
            sess.close();
            return true;
        }catch (HibernateException he){
            he.printStackTrace();
            logger.error("Hibernate could not delete book");
            return false;
        }

    }
}
