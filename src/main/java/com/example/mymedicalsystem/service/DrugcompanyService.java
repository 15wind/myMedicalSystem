package com.example.mymedicalsystem.service;

import com.example.mymedicalsystem.model.Drugcompany;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface DrugcompanyService extends IService<Drugcompany> {
    List<Drugcompany> searchByName(String name);
    boolean addDrugcompany(Drugcompany drugcompany);
    boolean updateDrugcompany(Drugcompany drugcompany);
}