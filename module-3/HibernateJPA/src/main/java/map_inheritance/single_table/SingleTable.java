package map_inheritance.single_table;


import javax.persistence.*;

public class SingleTable {

    public Vehicle save(Vehicle vehicle, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            em.persist(vehicle);

            em.getTransaction().commit(); // close transaction

            return vehicle;

        } catch (RollbackException ex) {
            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
