package com.isyscore.version.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isyscore.version.entity.Module;
import com.isyscore.version.entity.Os;
import com.isyscore.version.mapper.OSMapper;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OsService {


    @Autowired
    OSMapper osMapper;

    @Autowired
    ModuleService moduleService;


    /**
     * 获取所有OS
     * @return
     */
    public List<Os> getAllOS(){

        QueryWrapper<Os> wrapper = new QueryWrapper<Os>();

        List<Os> curOS = osMapper.selectList(wrapper);

        return curOS;
    }



    /**
     * 根据版本号，查询某个OS的详细信息
     * @param version
     * @return
     */
    public Os queryOsDetailByVersion(String version, String osName){
        QueryWrapper<Os> wrapper = new QueryWrapper<Os>();
        wrapper.eq("os_version",version);
        wrapper.eq("os_name",osName);

        Os ansOS = osMapper.selectOne(wrapper);


        return ansOS;
    }


    public Os updateOsProgress(Os item) {


        List<Module> moduleList = moduleService.getModuleByOsVersion(item.getOsVersion());

        Double sum = 0.0;
        for(Module m : moduleList){
            sum += m.getModuleProgress();
        }

        // 如果数据不同了，则更新
        if(!sum.equals(item.getOsProgress())){

            item.setOsProgress(sum/moduleList.size());

            osMapper.updateOsProgressByVersion(sum/moduleList.size(),item.getOsVersion());
        }


        return item;
    }
}
