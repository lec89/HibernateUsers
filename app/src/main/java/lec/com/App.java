package lec.com;

import lec.com.ejemplos.EjemploInsert;

public class App {
    public String getGreeting() {
        return "Usuarios!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
                
        Runnable r = new EjemploInsert();
        r.run();        
    }
}