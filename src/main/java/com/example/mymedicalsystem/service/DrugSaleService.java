package com.example.mymedicalsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymedicalsystem.model.DrugSale;

import java.util.List;

public interface DrugSaleService extends IService<DrugSale> {
    List<DrugSale> listAllDrugSales();
    List<DrugSale> listDrugSalesWithSaleInfo();
    Long getMaxId(); // 新增获取最大 ID 的方法
}