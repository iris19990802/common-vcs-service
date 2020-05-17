package com.isyscore.version.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isyscore.version.api.bo.SABo;
import com.isyscore.version.api.bo.ServiceDetailBO;
import com.isyscore.version.entity.Service;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

@Mapper
public interface ServiceMapper extends BaseMapper<Service> {


    List<SABo> getAllService();


    List<SABo> getServiceByCondition(@Param("paramsMap") Map<String,Object> map);


    @Select("select * from service " +
            "LEFT JOIN module ON service.module_id = module.module_id "+
            "LEFT JOIN os_module ON os_module.module_id = module.module_id "+
            "LEFT JOIN os ON os_module.os_version = os.os_version "+
            "WHERE os.os_version = \'${osVersion}\' AND os.os_name = \'${osName}\' " +
            "ORDER BY module.module_id"
    )
    List<SABo> getServiceByOsVersion(@Param("osVersion")String osVersion ,@Param("osName") String osName);




    ServiceDetailBO getOneServiceByModule(@Param("serviceName")String serviceName , @Param("moduleId")Integer moduleId);
}
