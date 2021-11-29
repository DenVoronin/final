package hhr.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@RestController
@Api(value = "Auth", description = "For add user info in project")

public class ValidationController {


    @GetMapping(value="/")
    @ApiOperation(value = "Enter point")
    public void hello1(HttpServletResponse response) throws IOException {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

        response.sendRedirect("http://localhost:3006/");

    }
}
