package hhr.entity;


import java.util.ArrayList;

public class User  {
    String name;
    ArrayList groups;

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




}
