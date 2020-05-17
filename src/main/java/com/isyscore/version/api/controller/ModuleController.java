package com.isyscore.version.api.controller;


import com.isyscore.version.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/module")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @PostMapping("/changeModuleProgress")
    public String changeModuleProgress(@PathParam("moduleId") Integer moduleId,
                                     @PathParam("moduleProgress") Double moduleProgress){

        moduleService.changeModuleProgress(moduleId,moduleProgress);

        return "{\"message\":\"success\"}";
//        return "success";
    }


}
