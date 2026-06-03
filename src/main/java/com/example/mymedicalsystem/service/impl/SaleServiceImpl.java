// SaleServiceImpl.java
package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.SaleMapper;
import com.example.mymedicalsystem.model.Sale;
import com.example.mymedicalsystem.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {

    @Override
    public List<Sale> listAllSales() {
        return this.list();
    }

    @Override
    public List<Sale> listSalesBySaleId(Long saleId) {
        return baseMapper.listSalesBySaleId(saleId);
    }
}
