package hhr.controllers;

import hhr.entity.*;
import hhr.services.Email;
import hhr.services.OvertimesService;
import hhr.services.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
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
    private ChangesServiceImpl changesServiceImpl;
    private Email email;
    @Autowired
    ProjectController(ProjectServiceImpl projectServiceImpl, CardStatusServiceImpl cardStatusServiceImpl,
                      DevMethodologyServiceImpl devMethodologyServiceImpl, OvertimesServiceImpl overtimesServiceImpl,
                      ProjectStageServiceImpl projectStageServiceImpl, ProjectTypeServiceImpl projectTypeServiceImpl,
                      TimePlanServiceImpl timePlanServiceImpl, ChangesServiceImpl changesServiceImpl, Email email){

        this.projectServiceImpl = projectServiceImpl;
        this.cardStatusServiceImpl = cardStatusServiceImpl;
        this.devMethodologyServiceImpl = devMethodologyServiceImpl;
        this.overtimesServiceImpl = overtimesServiceImpl;
        this.projectStageServiceImpl = projectStageServiceImpl;
        this.projectTypeServiceImpl = projectTypeServiceImpl;
        this.timePlanServiceImpl = timePlanServiceImpl;
        this.changesServiceImpl = changesServiceImpl;
        this.email = email;
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
    public ProjectCard getFreeProject(@PathVariable("id") String id)  {

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
    public void  editProject(@PathVariable("id") String id, @RequestBody ProjectCard projectCard) throws NoSuchFieldException, IllegalAccessException {
        projectCard.setId(Integer.parseInt(id));
        Changes changes = new Changes();
        changes.setId(Integer.parseInt(id));
        changes.setName(projectServiceImpl.getById(Integer.parseInt(id)).equalsCustom(projectCard).toString());
        changesServiceImpl.newChanges(changes);
        projectServiceImpl.edit(projectCard);

    }

    @GetMapping (value="project/history/{id}")
    @ApiOperation(value = "Get history of project by id")
    public Changes getHistory(@PathVariable("id") String id)  {

        return changesServiceImpl.getById(Integer.parseInt(id));

    }

      @PreAuthorize("@UserRole.isUP()")
    @PostMapping (value="/project/find")
    @ApiOperation(value = "Find cards by param")
    public List<ProjectCard> findCards(@RequestBody FindHelper data) throws NoSuchFieldException, IllegalAccessException {


        if (new ProjectCard().findField(data.getParam())) {

            return projectServiceImpl.findCustom(data.getParam(), data.getValue());
        }


        List<ProjectCard> o = null;
        return o;
    }

    @PostMapping (value="/project/mail")
    @ApiOperation(value = "Send email")
    public void sendEmail(@RequestBody MailHelper data) {

        email.sendSimpleEmail(data.getMail(), data.getSubject(), data.getMessage());

    }



}
