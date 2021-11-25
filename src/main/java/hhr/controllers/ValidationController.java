package hhr.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Api(value = "Auth", description = "For add user info in project")
public class ValidationController {
    @GetMapping(value="/")
    @ApiOperation(value = "Enter point")
    public void hello1(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());


    }
}
