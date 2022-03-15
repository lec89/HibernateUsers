package lec.com.ejemplos;

import lec.com.components.ConectorJPA;
import lec.com.model.Usuario;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

public class FiltroClientSide implements Runnable {

    @Override
    public void run() {
        ConectorJPA conectorJPA = new ConectorJPA();
        EntityManager em = conectorJPA.getEntityManager();
        
        var query = em.createQuery("from Usuario u", Usuario.class);
        
        var usuarios = query
                .getResultStream()
                .filter(u -> u.altura == 4328)
                .filter(u -> u.pais.equals("Turkey"))
                .filter(u -> u.apellido.startsWith("B"))
                .filter(u -> u.nombre.startsWith("G"))
                .collect(Collectors.toList());
        
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}