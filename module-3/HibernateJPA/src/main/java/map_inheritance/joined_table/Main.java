package map_inheritance.joined_table;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        JoinedTable table = new JoinedTable();

        Car c1 = new Car();
        Car c2 = new Car();
        Boat b1 = new Boat();
        Boat b2 = new Boat();

        c1.setGears(5);
        c1.setMaxSpeed(160);
        c2.setGears(6);
        c2.setMaxSpeed(210);
        b1.setEngines(3);
        b1.setMaxSpeed(70);
        b2.setEngines(2);
        b2.setMaxSpeed(50);

        table.save(c1, emf);
        table.save(c2, emf);
        table.save(b1, emf);
        table.save(b2, emf);

        emf.close();
    }
}
