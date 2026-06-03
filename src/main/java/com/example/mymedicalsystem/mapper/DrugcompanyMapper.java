package com.example.mymedicalsystem.mapper;

import com.example.mymedicalsystem.model.Drugcompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface DrugcompanyMapper extends BaseMapper<Drugcompany> {
    @Select("SELECT MAX(company_id) FROM drugcompany")
    Long getMaxId();
}