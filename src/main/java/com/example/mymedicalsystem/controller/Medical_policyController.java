package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Medical_policy;
import com.example.mymedicalsystem.service.Medical_policyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical_policys")
public class Medical_policyController {
    @Autowired
    private Medical_policyService medical_policyService;

    @GetMapping("/queryMedical_policys")
    public List<Medical_policy> queryMedical_policys() {
        return medical_policyService.list();
    }

    // 修改添加接口
    @PostMapping
    public Medical_policy addMedicalPolicy(@RequestBody Medical_policy medicalPolicy) {
        return medical_policyService.saveWithId(medicalPolicy);
    }

    @PutMapping("/{id}")
    public Medical_policy updateMedicalPolicy(@PathVariable Long id, @RequestBody Medical_policy medicalPolicy) {
        medicalPolicy.setId(id);
        medical_policyService.updateById(medicalPolicy);
        return medicalPolicy;
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalPolicy(@PathVariable Long id) {
        medical_policyService.removeById(id);
    }
}