package com.example.mymedicalsystem.mapper;

import com.example.mymedicalsystem.model.Medical_policy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface Medical_policyMapper extends BaseMapper<Medical_policy> {
    // 添加获取最大ID的方法
    @Select("SELECT MAX(id) FROM medical_policy")
    Long selectMaxId();
}