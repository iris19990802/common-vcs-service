package com.isyscore.version.api.controller;


import com.isyscore.version.entity.Module;
import com.isyscore.version.entity.Os;
import com.isyscore.version.service.ModuleService;
import com.isyscore.version.service.OsService;
import com.isyscore.version.service.ServiceService;
import com.isyscore.version.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/OS")
public class OsController {

    @Autowired
    OsService osService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    ModuleService moduleService;


    /**
     * 进入 Os 初始页面，请求这个api
     * @return
     */
    @GetMapping("/getAllOS")
    public List<Os> getAllOS(){

        List<Os> ans = osService.getAllOS();

        for(Os item: ans){
            if(item.getIsHistory().equals(0)){

                item = osService.updateOsProgress(item);
            }
        }

        return ans;
    }




    @GetMapping("/getOsDetailByVersion")
    public Os getOsDetailByVersion(@RequestParam String osVersion,
                                   @RequestParam String osName){

        Os ans = osService.queryOsDetailByVersion(osVersion,osName);
        return ans;

    }




    @GetMapping("/queryServiceListByOsVersion")
    public PagedGridResult queryServiceListByOsVersion(
            @RequestParam String osVersion,
            @RequestParam String osName,
            @RequestParam Integer page,
            @RequestParam Integer pageSize

    ){
       PagedGridResult ans = serviceService.getServiceByOsVersion(osVersion,osName,page,pageSize);

       return ans;
    }
}
