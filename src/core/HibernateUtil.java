package core;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration c = new Configuration().configure();
            sessionFactory = c.buildSessionFactory();
        } catch (HibernateException he) {
            throw new ExceptionInInitializerError(he);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}