package hhr.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_stage")
public class ProjectStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
ProjectStage(){}
    ProjectStage(int id, String name){

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
