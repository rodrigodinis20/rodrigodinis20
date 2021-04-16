package map_inheritance.mapped_superclass;

import map_inheritance.table_per_class.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class MappedSuperclassInheritance {

    public AbstractModel save(AbstractModel abstractModel, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            em.persist(abstractModel);

            em.getTransaction().commit(); // close transaction

            return abstractModel;

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
    public AbstractModel update(AbstractModel abstractModel, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            AbstractModel savedVehicle = em.merge(abstractModel);
            em.getTransaction().commit(); // close transaction
            return abstractModel;

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
