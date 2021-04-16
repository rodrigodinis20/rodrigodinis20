package map_inheritance.single_table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        SingleTable table = new SingleTable();
        EntityManager em = emf.createEntityManager();

        Boat boat = new Boat();
        boat.setEngines(4);
        boat.setMaxSpeed(40);
        Car car = new Car();
        car.setGears(5);
        car.setMaxSpeed(160);

        Boat boat1 = new Boat();
        boat1.setEngines(4);
        boat1.setMaxSpeed(60);
        Boat boat2 = new Boat();
        boat2.setEngines(3);
        boat2.setMaxSpeed(30);
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setGears(6);
        car2.setGears(5);
        car1.setMaxSpeed(220);
        car2.setMaxSpeed(140);

        table.save(boat, emf);
        table.save(car, emf);
        table.save(boat1, emf);
        table.save(boat2, emf);
        table.save(car1, emf);
        table.save(car2, emf);




        emf.close();
        /*System.out.println("Result: " +
                em.createNativeQuery("SELECT * FROM vehicle_single_table;").
                        getSingleResult());

         */
    }
}
