package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Material;
import com.example.mymedicalsystem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materials")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @GetMapping("/getAllMaterial")
    public List<Material> getAllMaterials() {
        return materialService.list();
    }

    @GetMapping("/getMaterialsByTitle")
    public List<Material> getMaterialsByTitle(@RequestParam String title) {
        return materialService.getMaterialsByTitle(title);
    }

    @PostMapping("/addMaterial")
    public String addMaterial(@RequestBody Material material) {
        boolean saved = materialService.addMaterial(material);
        return saved ? "Material added successfully" : "Failed to add material";
    }

    @PutMapping("/updateMaterial/{id}")
    public String updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        material.setId(id);
        boolean updated = materialService.updateMaterial(material);
        return updated ? "Material updated successfully" : "Failed to update material";
    }

    @DeleteMapping("/deleteMaterial/{id}")
    public String deleteMaterial(@PathVariable Long id) {
        boolean deleted = materialService.removeById(id);
        return deleted ? "Material deleted successfully" : "Failed to delete material";
    }
}