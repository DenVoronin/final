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
    private  ProductServiceImpl productServiceImpl;
    private PayServiceImpl payServiceImpl;
    private ProjCatServiceImpl projCatServiceImpl;


    ValuesController(CardStatusServiceImpl cardStatusServiceImpl,ProductServiceImpl productServiceImpl,
                      DevMethodologyServiceImpl devMethodologyServiceImpl, OvertimesServiceImpl overtimesServiceImpl,
                      ProjectStageServiceImpl projectStageServiceImpl, ProjectTypeServiceImpl projectTypeServiceImpl,
                      TimePlanServiceImpl timePlanServiceImpl,PayServiceImpl payServiceImpl,ProjCatServiceImpl projCatServiceImpl){


        this.cardStatusServiceImpl = cardStatusServiceImpl;
        this.devMethodologyServiceImpl = devMethodologyServiceImpl;
        this.overtimesServiceImpl = overtimesServiceImpl;
        this.projectStageServiceImpl = projectStageServiceImpl;
        this.projectTypeServiceImpl = projectTypeServiceImpl;
        this.timePlanServiceImpl = timePlanServiceImpl;
        this.payServiceImpl = payServiceImpl;
        this.projCatServiceImpl=projCatServiceImpl;
        this.productServiceImpl=productServiceImpl;
    }
    @GetMapping(value="/card_status")
    @ApiOperation(value = "List of card status")
    public List<CardStatus> getcs(){
        return cardStatusServiceImpl.getAll();
    }


    @GetMapping(value="/product")
    @ApiOperation(value = "List of development(product)")
    public List<Product> getprod(){
        return productServiceImpl.getAll();
    }


    @GetMapping(value="/pay")
    @ApiOperation(value = "List of pay")
    public List<Pay> getpay(){
        return payServiceImpl.getAll();
    }


    @GetMapping(value="/project_category")
    @ApiOperation(value = "List of project_category")
    public List<ProjCat> getpc(){
        return projCatServiceImpl.getAll();
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
