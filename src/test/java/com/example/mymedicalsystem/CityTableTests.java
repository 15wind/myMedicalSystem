package com.example.mymedicalsystem;

import com.example.mymedicalsystem.model.City;
import com.example.mymedicalsystem.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CityTableTests {

    @Autowired
    private CityService cityService;

    // 增
    @Test
    public void testInsert() {
        City city = new City();
        city.setCityNumber(1001);
        city.setCreatetime(new Date());
        city.setUpdatetime(new Date());

        assertTrue(cityService.save(city));
        assertNotNull(cityService.getById(city.getCityId()));
    }

    // 改
    @Test
    public void testUpdate() {
        City city = new City();
        city.setCityNumber(2002);
        city.setCreatetime(new Date());
        city.setUpdatetime(new Date());
        cityService.save(city);

        city.setCityNumber(3003);
        assertTrue(cityService.updateById(city));
        assertEquals(3003, cityService.getById(city.getCityId()).getCityNumber());
    }

    // 删
    @Test
    public void testDelete() {
        City city = new City();
        city.setCityNumber(4004);
        city.setCreatetime(new Date());
        city.setUpdatetime(new Date());
        cityService.save(city);

        assertTrue(cityService.removeById(city.getCityId()));
        assertNull(cityService.getById(city.getCityId()));
    }

    // 查
    @Test
    public void testQuery() {
        City city = new City();
        city.setCityNumber(5005);
        city.setCreatetime(new Date());
        city.setUpdatetime(new Date());
        cityService.save(city);

        City queriedCity = cityService.getById(city.getCityId());
        assertNotNull(queriedCity);
        assertEquals(5005, queriedCity.getCityNumber());
    }
}