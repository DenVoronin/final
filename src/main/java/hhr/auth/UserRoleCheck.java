package hhr.auth;

import org.springframework.stereotype.Component;
import static hhr.auth.SuccessHandlerCustom.user;

@Component("UserRole")
public class UserRoleCheck {

   public  Boolean isUP() { return user.getRole().equals("UP"); }
    public  Boolean isLR() { return user.getRole().equals("LR"); }
    public  Boolean isRS() { return user.getRole().equals("RS"); }
}
