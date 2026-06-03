// SaleController.java
package com.example.mymedicalsystem.controller;
import java.util.Date;
import com.example.mymedicalsystem.model.Sale;
import com.example.mymedicalsystem.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/list")
    public ResponseEntity<List<Sale>> listSales() {
        List<Sale> sales = saleService.listAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/listWithSaleId")
    public ResponseEntity<List<Sale>> listSalesBySaleId(@RequestParam Long saleId) {
        List<Sale> sales = saleService.listSalesBySaleId(saleId);
        if (sales == null || sales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    // 新增添加销售信息的接口
    // SaleController.java
    @PostMapping("/add")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        boolean success = saleService.save(sale);
        if (success) {
            // 重新查询以获取包含自动填充字段的数据
            Sale savedSale = saleService.getById(sale.getSaleId());
            return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{saleId}/update")
    public ResponseEntity<String> updateSale(@PathVariable Long saleId, @RequestBody Sale sale) {
        sale.setSaleId(saleId);
        boolean success = saleService.updateById(sale);
        return success ?
                new ResponseEntity<>("销售信息更新成功", HttpStatus.OK) :
                new ResponseEntity<>("更新失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 删除销售信息
    @DeleteMapping("/{saleId}/delete")
    public ResponseEntity<String> deleteSale(@PathVariable Long saleId) {
        boolean success = saleService.removeById(saleId);
        return success ?
                new ResponseEntity<>("销售信息删除成功", HttpStatus.OK) :
                new ResponseEntity<>("删除失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
