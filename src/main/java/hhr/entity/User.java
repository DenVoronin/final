package hhr.entity;


import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
