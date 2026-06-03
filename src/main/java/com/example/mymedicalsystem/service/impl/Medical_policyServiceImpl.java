package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.Medical_policyMapper;
import com.example.mymedicalsystem.model.Medical_policy;
import com.example.mymedicalsystem.service.Medical_policyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Medical_policyServiceImpl extends ServiceImpl<Medical_policyMapper, Medical_policy> implements Medical_policyService {

    @Autowired
    private Medical_policyMapper medicalPolicyMapper;

    @Override
    public Long getMaxId() {
        // 使用Mapper查询最大ID
        Long maxId = medicalPolicyMapper.selectMaxId();
        return maxId != null ? maxId : 0L;
    }

    @Override
    public Medical_policy saveWithId(Medical_policy medicalPolicy) {
        // 获取最大ID并+1
        Long maxId = getMaxId();
        medicalPolicy.setId(maxId + 1);

        // 保存实体
        this.save(medicalPolicy);
        return medicalPolicy;
    }
}