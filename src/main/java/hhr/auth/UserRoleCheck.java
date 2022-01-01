package hhr.auth;

import hhr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("UserRole" )
public class UserRoleCheck {
@Autowired
    User user;

   public  Boolean isUP() { return user.getRole().equals("UP"); }
    public  Boolean isLR() { return user.getRole().equals("LR"); }
    public  Boolean isRS() { return user.getRole().equals("RS"); }
}
