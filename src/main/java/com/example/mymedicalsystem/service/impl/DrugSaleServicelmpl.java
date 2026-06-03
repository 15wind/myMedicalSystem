package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.DrugSaleMapper;
import com.example.mymedicalsystem.model.DrugSale;
import com.example.mymedicalsystem.service.DrugSaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugSaleServicelmpl extends ServiceImpl<DrugSaleMapper, DrugSale> implements DrugSaleService {

    @Override
    public List<DrugSale> listAllDrugSales() {
        return this.list();
    }

    @Override
    public List<DrugSale> listDrugSalesWithSaleInfo() {
        return getBaseMapper().listDrugSalesWithSaleInfo();
    }

    @Override
    public Long getMaxId() {
        return baseMapper.selectMaxId(); // 调用 Mapper 中的方法获取最大 ID
    }
}