package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "timeplan")
public class TimePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    TimePlan(int id, String name){
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
