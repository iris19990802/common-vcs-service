package com.isyscore.version.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isyscore.version.api.bo.SABo;
import com.isyscore.version.api.bo.ServiceDetailBO;
import com.isyscore.version.entity.Os;
import com.isyscore.version.entity.Service;
import com.isyscore.version.mapper.ServiceMapper;
import com.isyscore.version.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.isyscore.version.utils.PageUtils.setterPagedGrid;


@Component
public class ServiceService {

    @Autowired
    ServiceMapper serviceMapper;

    @Autowired
    ModuleService moduleService;


    public PagedGridResult getAllService(Integer page, Integer pageSize){

        PageHelper.startPage(page,pageSize);

        List<SABo> resultList =  serviceMapper.getAllService();

        renderSAResult(resultList);

        PagedGridResult resultGrid = setterPagedGrid(resultList,page);


        return resultGrid;

    }


    public PagedGridResult getServiceByCondition(String osVersion, String moduleVersion, String moduleName, Integer page, Integer pageSize){

        Map<String,Object> mp = new HashMap<>();
        mp.put("osVersion",osVersion);
        mp.put("moduleVersion",moduleVersion);
        mp.put("moduleName",moduleName);


        // 开始分页（在sql之前）
        PageHelper.startPage(page,pageSize);

        List<SABo> resultList =  serviceMapper.getServiceByCondition(mp);

        renderSAResult(resultList);

        // 封装分页数据
        PagedGridResult resultGrid = setterPagedGrid(resultList,page);


        return resultGrid;

    }



    public PagedGridResult getServiceByOsVersion(String osVersion, String osName,Integer page, Integer pageSize){



        // 开始分页（在sql之前）
        PageHelper.startPage(page,pageSize);

        List<SABo> resultList =  serviceMapper.getServiceByOsVersion(osVersion,osName);

        renderSAResult(resultList);
        // 封装分页数据
        PagedGridResult resultGrid = setterPagedGrid(resultList,page);


        return resultGrid;

    }


    public ServiceDetailBO getOneServiceByModule(String serviceName, Integer moduleId){


        ServiceDetailBO ans = serviceMapper.getOneServiceByModule(serviceName,moduleId);

        if(null == ans.getServiceProgress()){
            ans.setServiceProgress(1.0);
        }

        return ans;
    }


    private void renderSAResult (List<SABo> SABo){

        for(int i=1 ; i <= SABo.size() ; i++){
            SABo target =  SABo.get(i-1);

            target.setId(i);

            List<String> osLst = new ArrayList<>();

            if(null == target.getServiceProgress()){
                target.setServiceProgress(1.0);
            }

            if(null != target.getOsLst()){
                for(Os os : target.getOsLst()){
                    osLst.add(os.getOsVersion());
                }
                target.setOs(osLst);
            }
        }
    }
}
