package dev.wan.actortests;

import dev.wan.entities.Actor;
import dev.wan.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class ActorTests {

    @Test
    void get_actor(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Actor actor = sess.get(Actor.class, 3);
        System.out.println(actor);
        sess.close();
    }
}
