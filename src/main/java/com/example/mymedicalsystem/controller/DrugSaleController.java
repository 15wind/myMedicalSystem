package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.DrugSale;
import com.example.mymedicalsystem.service.DrugSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drug_sale")
public class DrugSaleController {

    @Autowired
    private DrugSaleService drugSaleService;

    // 查询所有记录
    @GetMapping("/list")
    public ResponseEntity<List<DrugSale>> listDrugSales() {
        List<DrugSale> list = drugSaleService.listAllDrugSales();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 查询带有销售信息的记录
    @GetMapping("/listWithSaleInfo")
    public ResponseEntity<List<DrugSale>> listDrugSalesWithSaleInfo() {
        List<DrugSale> list = drugSaleService.listDrugSalesWithSaleInfo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 新增记录
    @PostMapping("/add")
    public ResponseEntity<String> addDrugSale(@RequestBody DrugSale drugSale) {
        Long maxId = drugSaleService.getMaxId(); // 获取最大 ID
        if (maxId == null) {
            maxId = 0L; // 如果没有记录，最大 ID 设为 0
        }
        drugSale.setId(maxId + 1); // 设置新记录的 ID 为最大 ID 加 1
        boolean success = drugSaleService.save(drugSale);
        return success ?
                new ResponseEntity<>("关联记录添加成功", HttpStatus.OK) :
                new ResponseEntity<>("添加失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 更新记录
    @PutMapping("/update")
    public ResponseEntity<String> updateDrugSale(@RequestBody DrugSale drugSale) {
        boolean success = drugSaleService.updateById(drugSale);
        return success ?
                new ResponseEntity<>("关联记录更新成功", HttpStatus.OK) :
                new ResponseEntity<>("更新失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 删除记录
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteDrugSale(@PathVariable Long id) {
        boolean success = drugSaleService.removeById(id);
        return success ?
                new ResponseEntity<>("关联记录删除成功", HttpStatus.OK) :
                new ResponseEntity<>("删除失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}