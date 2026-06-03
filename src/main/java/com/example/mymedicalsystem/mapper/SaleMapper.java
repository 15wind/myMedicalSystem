// SaleMapper.java
package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleMapper extends BaseMapper<Sale> {
    @Select("SELECT * FROM sale WHERE sale_id = #{saleId}")
    List<Sale> listSalesBySaleId(Long saleId);
}