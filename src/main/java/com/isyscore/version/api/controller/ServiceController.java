package com.isyscore.version.api.controller;

import com.isyscore.version.api.bo.ServiceDetailBO;
import com.isyscore.version.entity.Service;
import com.isyscore.version.service.ServiceService;
import com.isyscore.version.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/service")
public class ServiceController {


    @Autowired
    ServiceService serviceService;



    @GetMapping("/getAllService")
    public PagedGridResult getAllService(@RequestParam @NotNull Integer page,
                                         @RequestParam @NotNull Integer pageSize){


        /**
         * 对 service 分页查询
         */
        PagedGridResult ans = serviceService.getAllService(page,pageSize);



        /**
         * 整合service查询结果，生成 ModuleDetailBO
         */

        return ans;

    }


    @GetMapping("/getServiceByCondition")
    public PagedGridResult getServiceByCondition(@RequestParam(required=false) String osVersion,
                                            @RequestParam(required=false) String moduleVersion,
                                            @RequestParam(required=false) String moduleName,
                                            @RequestParam @NotNull Integer page,
                                            @RequestParam @NotNull Integer pageSize
    ){

        PagedGridResult ans = serviceService.getServiceByCondition(osVersion,moduleVersion,moduleName,page,pageSize);

        return ans;

    }


    @GetMapping("/getOneServiceByModule")
    public ServiceDetailBO getOneServiceByModule(String serviceName, Integer moduleId){

        ServiceDetailBO ans = serviceService.getOneServiceByModule(serviceName,moduleId);

        return ans;
    }

}
