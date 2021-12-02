package hhr.auth;


import hhr.config.LdapSearch;
import hhr.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SuccessHandlerCustom implements AuthenticationSuccessHandler {



    @Value("${group.UP}")
    private String up;

    @Value("${group.LR}")
    private String lr;

    @Value("${group.RS}")
    private String rs;


    static public User user = new User();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {


        user.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setGroups(new LdapSearch().findGroupsByUsername(user.getName()));


        if (user.getGroups().contains(up))
            user.setRole("UP");


        if (user.getGroups().contains(lr))
            user.setRole("LR");

        if (user.getGroups().contains(rs))
            user.setRole("RS");


    }

}