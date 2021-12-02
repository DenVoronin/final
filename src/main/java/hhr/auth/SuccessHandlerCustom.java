package hhr.auth;


import hhr.config.LdapSearch;
import hhr.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SuccessHandlerCustom implements AuthenticationSuccessHandler {
    static public User user = new User();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {


        user.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setGroups(new LdapSearch().findGroupsByUsername(user.getName()));

    }
}
