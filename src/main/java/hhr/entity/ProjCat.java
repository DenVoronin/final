package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class ProjCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    ProjCat(int id, String name){
        this.name = name;
        this.id=id;
    }
    ProjCat(){}
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Сategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
