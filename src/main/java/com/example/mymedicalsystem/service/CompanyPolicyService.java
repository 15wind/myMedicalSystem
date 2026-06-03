package com.example.mymedicalsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mymedicalsystem.model.CompanyPolicy;

import java.util.List;

public interface CompanyPolicyService extends IService<CompanyPolicy> {
    List<CompanyPolicy> searchPolicies(String keyword, Long id, Long companyId);

    List<CompanyPolicy> searchPolicies(String keyword, Long id);

    Long getMaxId();
}