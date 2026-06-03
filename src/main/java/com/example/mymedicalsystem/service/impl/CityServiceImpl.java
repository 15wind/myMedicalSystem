package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.CityMapper;
import com.example.mymedicalsystem.model.City;
import com.example.mymedicalsystem.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
    // 可在此实现自定义方法
}