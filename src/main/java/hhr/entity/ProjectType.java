package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "projecttype")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    ProjectType(int id, String name){
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
