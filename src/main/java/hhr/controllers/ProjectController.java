package hhr.controllers;

import hhr.entity.ProjectCard;
import hhr.services.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/project/api")
@Api(value = "API", description = "For manage projects")
public class ProjectController {

    private ProjectServiceImpl projectServiceImpl;
    @Autowired
    ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping(value="/")
    @ApiOperation(value = "Enter point")
        public HashMap hello(){

        HashMap map = new HashMap();
        map.put("its","ok");
        return map;
        }

    @PostMapping (value="/new")
    @ApiOperation(value = "Create new")
    public String create(@RequestBody ProjectCard projectCard){

        projectServiceImpl.newProject(projectCard);
        return "create";
    }


}
