package hhr.controllers;

import hhr.entity.*;
import hhr.services.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/values")
@Api(value = "Values", description = "Get any values from DataBase")
public class ValuesController {

    private CardStatusServiceImpl cardStatusServiceImpl;
    private DevMethodologyServiceImpl devMethodologyServiceImpl;
    private OvertimesServiceImpl overtimesServiceImpl;
    private ProjectStageServiceImpl projectStageServiceImpl;
    private ProjectTypeServiceImpl projectTypeServiceImpl;
    private TimePlanServiceImpl timePlanServiceImpl;

    ValuesController(CardStatusServiceImpl cardStatusServiceImpl,
                      DevMethodologyServiceImpl devMethodologyServiceImpl, OvertimesServiceImpl overtimesServiceImpl,
                      ProjectStageServiceImpl projectStageServiceImpl, ProjectTypeServiceImpl projectTypeServiceImpl,
                      TimePlanServiceImpl timePlanServiceImpl){


        this.cardStatusServiceImpl = cardStatusServiceImpl;
        this.devMethodologyServiceImpl = devMethodologyServiceImpl;
        this.overtimesServiceImpl = overtimesServiceImpl;
        this.projectStageServiceImpl = projectStageServiceImpl;
        this.projectTypeServiceImpl = projectTypeServiceImpl;
        this.timePlanServiceImpl = timePlanServiceImpl;
    }
    @GetMapping(value="/card_status")
    @ApiOperation(value = "List of card status")
    public List<CardStatus> getcs(){
        return cardStatusServiceImpl.getAll();
    }

    @GetMapping(value="/dev_method")
    @ApiOperation(value = "List of dev methodology")
    public List<DevMethodology> getdm(){
        return devMethodologyServiceImpl.getAll();
    }

    @GetMapping(value="/overtimes")
    @ApiOperation(value = "List of overtimes")
    public List<Overtimes> getot(){
        return overtimesServiceImpl.getAll();
    }

    @GetMapping(value="/project_stage")
    @ApiOperation(value = "List of project stage")
    public List<ProjectStage> getps(){
        return projectStageServiceImpl.getAll();
    }

    @GetMapping(value="/project_type")
    @ApiOperation(value = "List of project status")
    public List<ProjectType> getpt(){
        return projectTypeServiceImpl.getAll();
    }

    @GetMapping(value="/time_plan")
    @ApiOperation(value = "List of time plans")
    public List<TimePlan> gettp(){
        return timePlanServiceImpl.getAll();
    }
}
