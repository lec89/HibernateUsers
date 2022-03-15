package lec.com.ejemplos;

import lec.com.components.ConectorJPA;
import lec.com.model.Usuario;
import javax.persistence.EntityManager;

public class BuscarPorId implements Runnable {

    @Override
    public void run() {
        ConectorJPA conectorJPA = new ConectorJPA();
        EntityManager em = conectorJPA.getEntityManager();
        
        Usuario u = em.find(Usuario.class, "152e5275-a1ae-4018-a121-bd27c0626882");
        
        if (u == null) {
            System.out.println("No se encontro el usuario");
            return;
        }
            System.out.println(u);        
    }
}