package associations.one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Category category1 = new Category();
        category1.setName("Category 1");
        Category category2 = new Category();
        category2.setName("Category 2");
        em.persist(category1);
        em.persist(category2);

        for (int i = 1; i <= 4; i++) {
            Product product = new Product();
            product.setCategory(category1);
            product.setName("Product " + i);
        }

        for (int i = 1; i <= 4; i++) {
            Product product = new Product();
            product.setCategory(category2);
            product.setName("Product " + (4 + i));
        }

        em.getTransaction().commit();
        em.close();
    }
}
