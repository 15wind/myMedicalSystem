package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Drugcompany;
import com.example.mymedicalsystem.service.DrugcompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/drugcompanys")
public class DrugcompanyController {
    @Autowired
    private DrugcompanyService drugcompanyService;

    // 查询所有医药公司
    @GetMapping("/queryDrugcompanys")
    public List<Drugcompany> queryDrugcompanys() {
        return drugcompanyService.list();
    }

    // 按公司名称搜索
    @GetMapping("/searchByName")
    public List<Drugcompany> searchByName(@RequestParam String name) {
        return drugcompanyService.searchByName(name);
    }

    // 添加医药公司
    @PostMapping("/add")
    public boolean addDrugcompany(@RequestBody Drugcompany drugcompany) {
        return drugcompanyService.addDrugcompany(drugcompany);
    }

    // 修改医药公司
    @PostMapping("/update")
    public boolean updateDrugcompany(@RequestBody Drugcompany drugcompany) {
        return drugcompanyService.updateDrugcompany(drugcompany);
    }

    // 删除医药公司
    @GetMapping("/delete/{id}")
    public boolean deleteDrugcompany(@PathVariable Long id) {
        return drugcompanyService.removeById(id);
    }
}