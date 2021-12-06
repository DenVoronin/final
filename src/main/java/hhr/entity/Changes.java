package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "changes")
public class Changes {
    @Id
    int id;
    @Column(length = 65535,columnDefinition="Text")
    String name;
    public Changes(){}
    Changes(int id, String name){
        this.id = id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Changes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
