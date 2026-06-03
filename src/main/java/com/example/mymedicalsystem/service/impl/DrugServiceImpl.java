package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.DrugMapper;
import com.example.mymedicalsystem.model.Drug;
import com.example.mymedicalsystem.service.DrugService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {

    @Override
    public List<Drug> searchDrugs(String keyword) {
        LambdaQueryWrapper<Drug> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Drug::getDrugName, keyword)
                .or()
                .like(Drug::getPublisher, keyword);
        return this.list(wrapper);
    }

    @Override
    public Long generateNewDrugId() {
        Long maxDrugId = baseMapper.selectMaxDrugId();
        return maxDrugId == null? 1 : maxDrugId + 1;
    }

    // 重写 save 方法，处理自定义 ID 生成（如果是添加药品场景）
    @Override
    public boolean save(Drug drug) {
        if (drug.getDrugId() == null) {
            Long newId = generateNewDrugId();
            drug.setDrugId(newId);
        }
        drug.setCreatetime(new Date());
        drug.setUpdatetime(new Date());
        return super.save(drug);
    }

}