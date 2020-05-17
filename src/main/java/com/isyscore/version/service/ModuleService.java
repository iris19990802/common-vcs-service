package com.isyscore.version.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isyscore.version.entity.Module;
import com.isyscore.version.mapper.ModuleMapper;
import com.isyscore.version.mapper.OsModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleService {

    @Autowired
    ModuleMapper moduleMapper;

    @Autowired
    ServiceService serviceService;

    @Autowired
    OsModuleMapper osModuleMapper;



    public boolean changeModuleProgress(Integer moduleId,Double moduleProgress){


        moduleMapper.changeModuleProgress(moduleId,moduleProgress);

        return true;
    }


    public List<Module> getModuleByOsVersion(String osVersion) {

        List<Module> lst = moduleMapper.getModuleByOsVersion(osVersion);

        return lst;

    }
}
