package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "devmethodology")
public class DevMethodology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

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
