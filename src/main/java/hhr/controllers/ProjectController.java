package hhr.controllers;

import hhr.entity.ProjectCard;
import hhr.entity.TimePlan;
import hhr.services.OvertimesService;
import hhr.services.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API", description = "For manage projects")
public class ProjectController {

    private ProjectServiceImpl projectServiceImpl;
    private CardStatusServiceImpl cardStatusServiceImpl;
    private DevMethodologyServiceImpl devMethodologyServiceImpl;
    private OvertimesServiceImpl overtimesServiceImpl;
    private ProjectStageServiceImpl projectStageServiceImpl;
    private ProjectTypeServiceImpl projectTypeServiceImpl;
    private TimePlanServiceImpl timePlanServiceImpl;
    @Autowired
    ProjectController(ProjectServiceImpl projectServiceImpl, CardStatusServiceImpl cardStatusServiceImpl,
                      DevMethodologyServiceImpl devMethodologyServiceImpl, OvertimesServiceImpl overtimesServiceImpl,
                      ProjectStageServiceImpl projectStageServiceImpl, ProjectTypeServiceImpl projectTypeServiceImpl,
                      TimePlanServiceImpl timePlanServiceImpl){

        this.projectServiceImpl = projectServiceImpl;
        this.cardStatusServiceImpl = cardStatusServiceImpl;
        this.devMethodologyServiceImpl = devMethodologyServiceImpl;
        this.overtimesServiceImpl = overtimesServiceImpl;
        this.projectStageServiceImpl = projectStageServiceImpl;
        this.projectTypeServiceImpl = projectTypeServiceImpl;
        this.timePlanServiceImpl = timePlanServiceImpl;
    }
    @PreAuthorize("@UserRole.isUP() OR @UserRole.isLR() OR @UserRole.isRS()")
    @GetMapping(value="/")
    @ApiOperation(value = "Enter point. Just return OK")
        public HashMap hello(){

        HashMap map = new HashMap();
        map.put("its","ok");
        return map;
        }
    @PreAuthorize("@UserRole.isUP()")
    @PostMapping (value="/project/new")
    @ApiOperation(value = "Create new")
    public int create(@RequestBody ProjectCard projectCard){

        projectServiceImpl.newProject(projectCard);
        return projectCard.getId();
    }
    @PreAuthorize("@UserRole.isUP() OR @UserRole.isLR() OR @UserRole.isRS()")
    @GetMapping (value="/project/{id}")
    @ApiOperation(value = "Get  project by id")
    public ProjectCard getProject(@PathVariable("id") String id){
        return projectServiceImpl.getById(Integer.parseInt(id));
    }

    @GetMapping (value="/free/{id}")
    @ApiOperation(value = "Get FREE project by id")
    public ProjectCard getFreeProject(@PathVariable("id") String id){
        return projectServiceImpl.getById(Integer.parseInt(id));
    }
    @PreAuthorize("@UserRole.isUP() OR @UserRole.isLR() OR @UserRole.isRS()")
    @GetMapping(value="/project")
    @ApiOperation(value = "List of all project")
    public List<ProjectCard> getProjects() {
        return projectServiceImpl.getAllCustom();
    }

    @PreAuthorize("@UserRole.isUP()")
    @GetMapping (value="/project/delete/{id}")
    @ApiOperation(value = "Delete project by id")
    public void deleteProject(@PathVariable("id") String id){
        projectServiceImpl.delete(Integer.parseInt(id));
    }


    @PreAuthorize("@UserRole.isUP()")
    @PostMapping (value="/project/edit/{id}")
    @ApiOperation(value = "Edit project by id")
    public void  editProject(@PathVariable("id") String id, @RequestBody ProjectCard projectCard){
        projectCard.setId(Integer.parseInt(id));
        projectServiceImpl.edit(projectCard);

    }
}
