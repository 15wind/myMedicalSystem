package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.ChinaMapper;
import com.example.mymedicalsystem.model.China;
import com.example.mymedicalsystem.service.ChinaService;
import org.springframework.stereotype.Service;

@Service
public class ChinaServiceImpl extends ServiceImpl<ChinaMapper, China> implements ChinaService {
    @Override
    public Integer getMaxIdByParentId(int parentId) {
        return baseMapper.getMaxIdByParentId(parentId);
    }

    @Override
    public boolean save(China entity) {
        Integer maxId = getMaxIdByParentId(entity.getParentId());
        if (maxId == null) {
            entity.setId(1);
        } else {
            entity.setId(maxId + 1);
        }
        return super.save(entity);
    }
}