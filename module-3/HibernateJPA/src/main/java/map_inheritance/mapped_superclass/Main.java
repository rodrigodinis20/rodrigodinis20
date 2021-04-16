package map_inheritance.mapped_superclass;

import map_inheritance.single_table.SingleTable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        MappedSuperclassInheritance table = new MappedSuperclassInheritance();

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Account a1 = new Account();
        Account a2 = new Account();

        c1.setName("Alex");
        c2.setName("Benny");
        c3.setName("Mari");

        a1.setBalance(100.0);
        a2.setBalance(150.0);

        table.save(c1, emf);
        table.save(c2, emf);
        table.save(c3, emf);
        table.save(a1, emf);
        table.save(a2, emf);

        c1.setName("Alexio");
        table.update(c1, emf);

        emf.close();
    }
}
