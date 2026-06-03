package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.DrugcompanyMapper;
import com.example.mymedicalsystem.model.Drugcompany;
import com.example.mymedicalsystem.service.DrugcompanyService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class DrugcompanyServiceImpl extends ServiceImpl<DrugcompanyMapper, Drugcompany>
        implements DrugcompanyService {

    @Override
    public List<Drugcompany> searchByName(String name) {
        QueryWrapper<Drugcompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("company_name", name);
        return list(queryWrapper);
    }

    @Override
    public boolean addDrugcompany(Drugcompany drugcompany) {
        // 获取最大ID并+1
        Long maxId = getBaseMapper().getMaxId();
        drugcompany.setId(maxId != null ? maxId + 1 : 1);

        // 设置创建和更新时间
        Date now = new Date();
        drugcompany.setCreatetime(now);
        drugcompany.setUpdatetime(now);

        return save(drugcompany);
    }

    @Override
    public boolean updateDrugcompany(Drugcompany drugcompany) {
        // 只更新名称和联系方式
        Drugcompany entity = new Drugcompany();
        entity.setId(drugcompany.getId());
        entity.setName(drugcompany.getName());
        entity.setPhone(drugcompany.getPhone());
        entity.setUpdatetime(new Date()); // 更新修改时间

        return updateById(entity);
    }
}