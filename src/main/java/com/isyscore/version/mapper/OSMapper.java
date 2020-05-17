package com.isyscore.version.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isyscore.version.entity.Os;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OSMapper extends BaseMapper<Os> {

    @Update("update os set os_progress=${v} where os_version=\'${osVersion}\'")
    void updateOsProgressByVersion(@Param("v") double v, @Param("osVersion")String osVersion);
}
