package com.example.mymedicalsystem.service;
import com.example.mymedicalsystem.model.Medical_policy;
import com.baomidou.mybatisplus.extension.service.IService;

public interface Medical_policyService extends IService<Medical_policy>  {
    Long getMaxId();
    Medical_policy saveWithId(Medical_policy medicalPolicy);
}