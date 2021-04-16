package associations.many_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory efm = Persistence.createEntityManagerFactory("test");
        EntityManager em = efm.createEntityManager();

        em.getTransaction().begin();

        User u1 = new User();
        User u2 = new User();
        User u3 = new User();

        SecurityGroup sg1 = new SecurityGroup();
        SecurityGroup sg2 = new SecurityGroup();

        u1.add(sg1);
        u2.add(sg1);
        u3.add(sg2);

        u1.setUsername("Alex");
        u2.setUsername("Benny");
        u3.setUsername("Mari");
        u1.setPassword("mastercoder");
        u2.setPassword("mastercoder");
        u3.setPassword("mastercoder");

        sg1.setName("Security Group 1");
        sg2.setName("Security Group 2");


        User user = em.merge(u1);
        em.persist(u2);
        em.persist(u3);

        u1.setUsername("Alexio");

        //User user = em.merge(u1);

        //em.find(User.class, 1);

        em.getTransaction().commit();
        em.close();
    }
}
