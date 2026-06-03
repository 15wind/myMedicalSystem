package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.CompanyPolicy;
import com.example.mymedicalsystem.service.CompanyPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companyPolicies")
public class CompanyPolicyController {
    @Autowired
    private CompanyPolicyService companyPolicyService;

    // 获取所有公司政策
    @GetMapping("/getAllPolicies")
    public List<CompanyPolicy> getAllPolicies() {
        return companyPolicyService.list();
    }

    // 根据ID获取公司政策
    @GetMapping("/{id}")
    public CompanyPolicy getPolicyById(@PathVariable Long id) {
        return companyPolicyService.getById(id);
    }

    // 添加新的公司政策
    @PostMapping("/addPolicy")
    public boolean addPolicy(@RequestBody CompanyPolicy policy) {
        return companyPolicyService.save(policy);
    }

    // 更新公司政策
    @PutMapping("/updatePolicy/{id}")
    public boolean updatePolicy(@PathVariable Long id, @RequestBody CompanyPolicy policy) {
        policy.setId(id);
        return companyPolicyService.updateById(policy);
    }
    @GetMapping("/getMaxId")
    public Long getMaxId() {
        return companyPolicyService.getMaxId();
    }

    // 删除公司政策
    @DeleteMapping("/deletePolicy/{id}")
    public boolean deletePolicy(@PathVariable Long id) {
        return companyPolicyService.removeById(id);
    }

    // 搜索公司政策
    @GetMapping("/searchPolicies")
    public List<CompanyPolicy> searchPolicies(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value = "id", required = false) String id) {
        Long longId = id != null ? Long.parseLong(id) : null;
        return companyPolicyService.searchPolicies(keyword, longId);
    }
}