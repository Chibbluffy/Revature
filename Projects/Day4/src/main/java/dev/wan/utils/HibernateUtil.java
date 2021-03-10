package dev.wan.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // session factory
    // should only ever have one per application
    // session factories are very large objects. Creating them multiple times would be VERY slow
    // A singleton is a class you only ever have one of
    private static SessionFactory sf;

    public static SessionFactory getSessionFactory(){
        if(sf == null){
            Configuration cfg = new Configuration();
            sf = cfg.configure().buildSessionFactory();
        }
        return sf;
    }
}
