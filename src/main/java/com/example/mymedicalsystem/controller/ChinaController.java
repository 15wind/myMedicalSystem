package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.China;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.mymedicalsystem.service.ChinaService;

@RestController
@RequestMapping("/chinas")
public class ChinaController {
    @Autowired
    private ChinaService chinaService;

    @GetMapping("/queryChinas")
    public List<China> queryChinas() {
        return chinaService.list();
    }

    // 搜索功能
    @GetMapping("/search")
    public List<China> searchChinas(@RequestParam("query") String query) {
        return chinaService.lambdaQuery().like(China::getName, query).list();
    }

    // 编辑功能
    @PutMapping
    public boolean updateChina(@RequestBody China china) {
        return chinaService.updateById(china);
    }

    // 删除功能
    @DeleteMapping("/{id}")
    public boolean deleteChina(@PathVariable("id") int id) {
        return chinaService.removeById(id);
    }

    // 新增地区功能（返回完整对象）
    @PostMapping
    public China addChina(@RequestBody China china) {
        chinaService.save(china); // 保存后china对象已包含生成的ID
        return china; // 直接返回包含ID的对象
    }
}