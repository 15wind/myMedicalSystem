package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.CompanyPolicyMapper;
import com.example.mymedicalsystem.model.CompanyPolicy;
import com.example.mymedicalsystem.service.CompanyPolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
// 移除 abstract 关键字
public class CompanyPolicyImpl extends ServiceImpl<CompanyPolicyMapper, CompanyPolicy> implements CompanyPolicyService {
    @Override
    public List<CompanyPolicy> searchPolicies(String keyword, Long id) {
        return baseMapper.searchPolicies(keyword, id);
    }

    @Override
    public Long getMaxId() {
        QueryWrapper<CompanyPolicy> wrapper = new QueryWrapper<>();
        wrapper.select("MAX(id) as maxId");
        Map<String, Object> map = baseMapper.selectMaps(wrapper).get(0);
        Object maxIdObj = map.get("maxId");
        return maxIdObj != null ? Long.parseLong(maxIdObj.toString()) : 0L;
    }

    // 实现 searchPolicies 方法的重载
    @Override
    public List<CompanyPolicy> searchPolicies(String keyword, Long id, Long companyId) {
        // 这里暂时忽略 companyId 参数，调用已有的 searchPolicies 方法
        return searchPolicies(keyword, id);
    }
}