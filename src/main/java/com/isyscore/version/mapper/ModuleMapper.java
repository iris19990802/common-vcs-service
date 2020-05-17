package com.isyscore.version.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isyscore.version.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ModuleMapper extends BaseMapper<Module> {



    @Update("update module set module_progress = ${moduleProgress} where module.module_id = ${moduleId}")
    void changeModuleProgress(@Param("moduleId")Integer moduleId, @Param("moduleProgress") Double moduleProgress);


    @Select("select * from module where module_id in " +
            "(select os_module.module_id from os_module " +
            "left join os on " +
            "os.os_version = os_module.os_version " +
            "where os.os_version = \'${osVersion}\' )")
    List<Module> getModuleByOsVersion(@Param("osVersion") String osVersion);
}