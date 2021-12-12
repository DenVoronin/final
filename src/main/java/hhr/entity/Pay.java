package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    Pay(int id, String name){
        this.name = name;
        this.id=id;
    }
 Pay(){}
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
