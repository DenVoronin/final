package hhr.entity;
import javax.persistence.Entity;
import java.util.*;

public class User {
    String name;
    ArrayList groups;
    String role;
    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(ArrayList group) {
        this.groups = group;
    }

    public String getName() {
        return name;
    }

    public ArrayList getGroups() {
        return groups;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
