package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.DrugSale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DrugSaleMapper extends BaseMapper<DrugSale> {

    @Select("SELECT ds.*, s.sale_name, s.sale_phone, s.createtime, s.updatetime " +
            "FROM drug_sale ds " +
            "LEFT JOIN sale s ON ds.sale_id = s.sale_id")
    List<DrugSale> listDrugSalesWithSaleInfo();

    @Select("SELECT MAX(id) FROM drug_sale") // 获取最大 ID 的 SQL 查询
    Long selectMaxId();
}