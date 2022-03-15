package lec.com.components;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionManager {
    private EntityManager em;

    public TransactionManager(EntityManager em) {
        this.em = em;
    }
    
    private void doTransac(List objetos, EntityTransaction tx) {
        tx.begin();        
        for(Object o : objetos) {
            em.merge(o);
        }        
        tx.commit();
    }
    
    public void transac(List objetos) {
        var tx = em.getTransaction();
        try {
            doTransac(objetos, tx);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (Exception ex) {
            }
        }
    }
}