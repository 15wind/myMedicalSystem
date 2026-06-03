package com.example.mymedicalsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mymedicalsystem.model.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper extends BaseMapper<City> {
    // 可在此扩展自定义SQL方法（非必须）
}