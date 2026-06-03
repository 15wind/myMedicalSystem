package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MaterialMapper extends BaseMapper<Material> {
    @Select("SELECT MAX(id) FROM material")
    Long selectMaxId();
}