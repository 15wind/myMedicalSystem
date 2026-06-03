package com.example.mymedicalsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymedicalsystem.model.Material;

import java.util.List;

public interface MaterialService extends IService<Material> {
    List<Material> getMaterialsByTitle(String title);
    boolean addMaterial(Material material);
    boolean updateMaterial(Material material);
}