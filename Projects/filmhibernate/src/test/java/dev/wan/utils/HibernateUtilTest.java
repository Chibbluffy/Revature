package dev.wan.utils;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {

    @Test
    void creates_session_factory(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        System.out.println(sf);
    }

}