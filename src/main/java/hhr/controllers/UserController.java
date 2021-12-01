package hhr.controllers;

import hhr.config.LdapSearch;
import hhr.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.ldap.core.LdapTemplate;


import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;


import javax.naming.*;

import java.io.IOException;
import java.util.*;




@RestController
@Api(value = "/", description = "User actions")

public class UserController {

@Autowired
    LdapTemplate ldapTemplate;


    @GetMapping(value="/")
    @ApiOperation(value = "Hello")
    public HttpStatus welcome(){
        return HttpStatus.OK;
    }


    @GetMapping(value="/user/whoami")
    @ApiOperation(value = "Get username and user groups")
    public HashMap hello1() throws IOException, NamingException {

        User user = new User();
        HashMap map = new HashMap();
        user.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setGroups(new LdapSearch().findGroupsByUsername(user.getName()));


        map.put("username", user.getName());
        map.put("groups",user.getGroups() );

        return map;


    }
}
