package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.Drug;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;  // 确保导入此注解

@Mapper  // 添加此注解

public interface DrugMapper extends BaseMapper<Drug> {

    // 查询 drug 表中最大的 drugId
    @Select("SELECT MAX(drug_id) FROM drug")
    Long selectMaxDrugId();
}