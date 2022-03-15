package lec.com.ejemplos;

import com.github.javafaker.Faker;
import lec.com.components.ConectorJPA;
import lec.com.model.TipoUsuario;
import lec.com.model.Usuario;
import java.util.Random;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EjemploInsert implements Runnable {
    Faker fkr = new Faker();
    
    private Usuario inventarUsuario() {
        Usuario usu = new Usuario(
                UUID.randomUUID().toString(),                
                fkr.address().firstName(),
                fkr.address().lastName(),
                fkr.address().streetName(),
                new Random().nextInt(8999) + 1000,
                fkr.address().country(),
                new Random().nextInt(2) == 0 ? TipoUsuario.ADMINISTRADOR : TipoUsuario.NORMAL
        );
        return usu;
    }
    
    @Override
    public void run() {        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
                
        ConectorJPA conectorJPA = new ConectorJPA();
        EntityManager em = conectorJPA.getEntityManager();
                
        for (Integer x : new int[1000]) {
            EntityTransaction tx = em.getTransaction();
            
            try {
                tx.begin();
                em.persist(inventarUsuario());
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}