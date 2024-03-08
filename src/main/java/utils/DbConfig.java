package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConfig {
    private final static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test-unit");
    }

    public static EntityManager entityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
