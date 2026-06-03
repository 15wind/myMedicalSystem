package com.example.mymedicalsystem.mapper;

import com.example.mymedicalsystem.model.China;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChinaMapper extends BaseMapper<China> {
    // 查询指定上级地区下的最大ID
    @Select("SELECT MAX(id) FROM china WHERE parent_id = #{parentId}")
    Integer getMaxIdByParentId(@Param("parentId") int parentId);
}