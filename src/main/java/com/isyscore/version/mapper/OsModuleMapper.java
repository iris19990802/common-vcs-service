package com.isyscore.version.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isyscore.version.entity.Module;
import com.isyscore.version.entity.OsModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface OsModuleMapper extends BaseMapper<OsModule> {
}