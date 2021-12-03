package hhr.controllers;




import hhr.auth.UserRoleCheck;
import hhr.config.LdapSearch;
import hhr.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;


import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;


import javax.naming.*;

import java.io.IOException;

import static hhr.auth.SuccessHandlerCustom.user;


@RestController
@Api(value = "/", description = "User actions")

public class UserController {

@Autowired
UserRoleCheck authComponent;


    @GetMapping(value="/")
    @ApiOperation(value = "Hello")
    public HttpStatus welcome(){
        return HttpStatus.OK;
    }


    @GetMapping(value="/user/whoami")
    @ApiOperation(value = "Get username and user groups")
    public User hello1() throws IOException, NamingException {

        return user;


    }
    @GetMapping(value="/user/logout")
    @ApiOperation(value = "Bye")
    public HttpStatus Bye(){
        SecurityContextHolder.clearContext();
        return HttpStatus.OK;
    }
}
