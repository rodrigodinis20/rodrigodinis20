package org.academiadecodigo.rememberthename.persistence.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractModel implements Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                '}';
    }
}
