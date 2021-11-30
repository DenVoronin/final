package hhr.controllers;

import hhr.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ldap.core.LdapTemplate;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.*;



@RestController
@Api(value = "", description = "User actions")
@RequestMapping("/user")
public class UserController {

    @Autowired
    LdapTemplate ldapTemplate;



    @GetMapping(value="/whoami")
    @ApiOperation(value = "Get username")
    public HashMap hello1() throws IOException {

        User user = new User();
        HashMap map = new HashMap();
        user.setName(SecurityContextHolder.getContext().getAuthentication().getName());






       // user.setGroup(LdapQueryBuilder.query().);
        map.put("username", user.getName());
        map.put("role",user.toString());
        return map;


    }
}
