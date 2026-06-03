package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.DoctorMapper;
import com.example.mymedicalsystem.model.Doctor;
import com.example.mymedicalsystem.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    @Override
    @Transactional
    public boolean save(Doctor entity) {
        // 新增操作时生成ID（当前最大值加一）
        if (entity.getId() == null) {
            Long maxId = getMaxId();
            entity.setId(maxId + 1);
        }
        return super.save(entity);
    }

    @Override
    @Transactional
    public boolean updateById(Doctor entity) {
        // 编辑时确保ID不被修改
        Doctor original = getById(entity.getId());
        if (original != null) {
            // 保留原始ID，防止被前端篡改
            entity.setId(original.getId());
        }
        return super.updateById(entity);
    }

    /**
     * 获取当前最大ID
     */
    private Long getMaxId() {
        LambdaQueryWrapper<Doctor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Doctor::getId)
                .orderByDesc(Doctor::getId)
                .last("LIMIT 1");

        Doctor doctor = getOne(queryWrapper);
        return Objects.isNull(doctor) ? 0L : doctor.getId();
    }
}




