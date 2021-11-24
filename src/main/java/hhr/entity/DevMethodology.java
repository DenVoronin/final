package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "dev_methodology")
public class DevMethodology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
DevMethodology(){}
    DevMethodology(int id, String name){
        this.id = id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
