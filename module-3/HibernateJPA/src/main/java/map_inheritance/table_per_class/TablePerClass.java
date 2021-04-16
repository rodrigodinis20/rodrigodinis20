package map_inheritance.table_per_class;

import javax.persistence.*;

public class TablePerClass {

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

    public Vehicle update(Vehicle vehicle, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Vehicle savedVehicle = em.merge(vehicle);
            em.getTransaction().commit(); // close transaction
            return savedVehicle;

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
