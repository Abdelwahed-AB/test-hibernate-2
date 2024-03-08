package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfig {
    private final static SessionFactory SESSION_FACTORY;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();

        SESSION_FACTORY = configuration.buildSessionFactory();
    }


    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }
}
