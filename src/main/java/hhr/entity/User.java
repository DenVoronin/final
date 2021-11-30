package hhr.entity;


import org.springframework.ldap.query.LdapQuery;
import org.springframework.security.ldap.search.LdapUserSearch;

public class User  {
    String name;
    String group;

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }


}
