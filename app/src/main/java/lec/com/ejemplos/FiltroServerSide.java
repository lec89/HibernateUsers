package lec.com.ejemplos;

import lec.com.components.ConectorJPA;
import lec.com.model.Usuario;
import javax.persistence.EntityManager;

public class FiltroServerSide implements Runnable {

    @Override
    public void run() {
        ConectorJPA conectorJPA = new ConectorJPA();
        EntityManager em = conectorJPA.getEntityManager();
        
        var query = em.createQuery("from Usuario u where u.apellido = :apellido and " +
                "u.nombre = :nombre", Usuario.class);
        query.setParameter("apellido", "VonRueden");
        query.setParameter("nombre", "Sarita");
        var usuarios = query.getResultList();
        
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}