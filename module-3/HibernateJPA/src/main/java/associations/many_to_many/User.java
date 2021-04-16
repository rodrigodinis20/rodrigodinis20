package associations.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @ManyToMany(cascade = {CascadeType.ALL},
            mappedBy = "users",
            // fetch all security groups when fetching a user
            fetch = FetchType.EAGER
    )
    private List<SecurityGroup> sgroups = new ArrayList<>();

    public void add(SecurityGroup securityGroup) {
        sgroups.add(securityGroup);
        securityGroup.add(this);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // utility methods to update both sides of the relationship
}
