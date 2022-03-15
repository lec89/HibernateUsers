package lec.com.components;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectorJPA {
    private EntityManager em;
    
    public ConectorJPA(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernando");
        em = emf.createEntityManager();
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
}