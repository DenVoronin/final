package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "overtimes")
public class Overtimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
Overtimes(){}
    Overtimes(int id, String name){
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
