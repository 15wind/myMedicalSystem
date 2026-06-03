// SaleService.java
package com.example.mymedicalsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymedicalsystem.model.Sale;

import java.util.List;

public interface SaleService extends IService<Sale> {
    List<Sale> listAllSales();
    List<Sale> listSalesBySaleId(Long saleId);
}