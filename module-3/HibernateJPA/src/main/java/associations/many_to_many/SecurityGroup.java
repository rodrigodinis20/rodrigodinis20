package associations.many_to_many;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sgroup")
public class SecurityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(
            // mappedBy required for bidirectional association
            // mappedBy="sgroups",

            // delay fetching users until they are actually needed
            fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

