package associations.one_to_one;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // mappedBy is required for bidirectional associations, and it tells hibernate
    // to use the user foreign key on the Car table to define the Owner
    @OneToOne(cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner")
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}