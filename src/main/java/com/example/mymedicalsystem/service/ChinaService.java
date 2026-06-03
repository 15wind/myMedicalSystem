package com.example.mymedicalsystem.service;

import com.example.mymedicalsystem.model.China;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ChinaService extends IService<China> {
    // 查询指定上级地区下的最大ID
    Integer getMaxIdByParentId(int parentId);
}