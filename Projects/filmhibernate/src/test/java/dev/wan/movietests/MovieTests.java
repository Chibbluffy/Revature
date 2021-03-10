package dev.wan.movietests;

import dev.wan.entities.Movie;
import dev.wan.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;

public class MovieTests {
    @Test
    void create_director(){
        Movie movie = new Movie(0, "Ender's Game", 120, 1);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.beginTransaction();
        sess.save(movie);
        sess.getTransaction().commit();
        sess.close();

        System.out.println(movie);
        Assertions.assertTrue(movie.getMovieId() > 0);

    }


    // Hibernate provides 3 ways for you to make queries
    // 1. criteria API (very OOP centric)
    // 2. HQL (Hibernate Query Language)
    // 3. Native SQL (avoid if possible)

    @Test
    void criteria_query(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();

        // Hibernate 5
        CriteriaBuilder criteriaBuilder = sess.getCriteriaBuilder();
        CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);
        query.select(root);

        Query<Movie> q = sess.createQuery(query);
        List<Movie> results = q.getResultList();
        System.out.println(results);

        // Hibernate 4
        Criteria crit = sess.createCriteria(Movie.class);
//        crit.add(Restrictions.between("runtime", 99, 150));
        crit.add(Restrictions.like("title", "%2021")); // % is wildcard
        List<Movie> movies = crit.list();
        System.out.println(movies);

        // create criteria object
        // if you do nothing, it will get back all rows
        // restrictions are additive
        //
        sess.close();
    }

    @Test
    void hql_query(){
        // HQL is slightly more OOP version of SQL
        // advantages to HQL
        // An hql query will work on any SQL database
        // if you change HQL dialects, or version, your application will work the same

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        String hql = "FROM Movie m WHERE m.runtime = 100"; // everything in the hql is written
        // as if you know nothing about the names of the columns and tables
        // BUT you know the entities
        Query query = sess.createQuery(hql);
        List<Movie> movies = query.list();
        System.out.println(movies);
    }

    @Test
    void sql_query(){
        // Last resort
        // avoid if possible
        // Disadvantages
        // 1. tied down to one version/dialect of SQL
        // 2. results are not automatically returned as objects. Get ResultSet
        String sql = "SELECT * FROM director";
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        sess.getTransaction();
        Query query = sess.createSQLQuery(sql);
        List<Object> objects= query.list();
        HashSet<Movie> movies = new HashSet<Movie>();
        for (Object o: objects){
            movies.add((Movie) o);
        }
        System.out.println(movies);
    }
}
