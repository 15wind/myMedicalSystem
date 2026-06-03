package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.MaterialMapper;
import com.example.mymedicalsystem.model.Material;
import com.example.mymedicalsystem.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {
    @Override
    public List<Material> getMaterialsByTitle(String title) {
        return baseMapper.selectList(new QueryWrapper<Material>().like("title", title));
    }

    @Override
    public boolean addMaterial(Material material) {
        Long maxId = baseMapper.selectMaxId();
        if (maxId == null) {
            maxId = 0L;
        }
        material.setId(maxId + 1);
        material.setCreateTime(new Date());
        material.setUpdateTime(new Date());
        return save(material);
    }

    @Override
    public boolean updateMaterial(Material material) {
        material.setUpdateTime(new Date());
        return updateById(material);
    }
}