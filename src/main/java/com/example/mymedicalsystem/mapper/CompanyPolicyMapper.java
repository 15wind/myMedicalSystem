package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.CompanyPolicy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyPolicyMapper extends BaseMapper<CompanyPolicy> {
    List<CompanyPolicy> searchPolicies(@Param("keyword") String keyword, @Param("id") Long id);
}