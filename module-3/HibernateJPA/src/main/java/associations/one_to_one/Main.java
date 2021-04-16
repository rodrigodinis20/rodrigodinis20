package associations.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();

        Owner o1 = new Owner();
        Owner o2 = new Owner();
        Owner o3 = new Owner();


        c1.setMake("Audi");
        c2.setMake("Opel");
        c3.setMake("MBW");

        c1.setModel("Quattro");
        c2.setModel("Astra");
        c3.setModel("M5");

        c1.setOwner(o1);
        c2.setOwner(o2);
        c3.setOwner(o3);

        o1.setCar(c1);
        o2.setCar(c2);
        o3.setCar(c3);

        o1.setName("Alex");
        o2.setName("Mari");
        o3.setName("Benny");

        em.persist(o1);
        em.persist(o2);
        em.persist(o3);
        //em.persist(c1);
        //em.persist(c2);
        //em.persist(c3);

        em.getTransaction().commit();
        em.close();
    }
}
