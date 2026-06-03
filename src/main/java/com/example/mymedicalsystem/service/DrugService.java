package com.example.mymedicalsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymedicalsystem.model.Drug;

import java.util.List;

public interface DrugService extends IService<Drug> {

    List<Drug> searchDrugs(String keyword);

    // 新增方法，用于生成新的药品 ID
    Long generateNewDrugId();
}