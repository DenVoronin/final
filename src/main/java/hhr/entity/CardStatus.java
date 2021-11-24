package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "card_status")
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    CardStatus(int id, String name){
        this.name = name;
        this.id=id;
    }
 CardStatus(){}
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
