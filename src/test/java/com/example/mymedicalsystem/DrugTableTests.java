package com.example.mymedicalsystem;

import com.example.mymedicalsystem.model.Drug;
import com.example.mymedicalsystem.service.DrugService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DrugTableTests {
    @Autowired
    private DrugService drugService;

    @Test
    public void testDrugListAll() {
        // 测试查询所有药品记录
        // 1. 调用list()获取全部药品列表
        // 2. 输出每条药品信息
        // 3. 统计并输出总记录数
        List<Drug> drugs = drugService.list();
        drugs.forEach(System.out::println);
        System.out.println("Total drugs: " + drugService.count());
    }

    @Test
    public void testGetDrugById() {
        // 测试通过主键ID查询单个药品
        // 1. 使用示例ID 12850467（需确保该ID存在）
        // 2. 注意ID类型为Long，数值需加L后缀
        Drug drug = drugService.getById(12650466);
        System.out.println(drug);
    }

    @Test
    public void testQueryByCondition() {
        // 测试多条件组合查询
        // 1. 创建查询条件Map，键名需与数据库列名一致
        // 2. 同时匹配 drug_name 和 publisher 字段
        // 3. 输出符合条件的结果
        Map<String, Object> condition = new HashMap<>() {{
            put("drug_name", "复方氨酚烷胺片(感叹号)");  // 数据库列名，非Java字段名
            put("publisher", "孟雅");
        }};
        List<Drug> drugs = drugService.listByMap(condition);
        drugs.forEach(System.out::println);
    }

    @Test
    public void testDeleteDrug() {
        // 测试删除指定ID的药品记录
        // 1. 使用示例ID 12850468（需实际存在）
        // 2. 注意删除操作不可逆
        // 3. 返回布尔值表示操作结果
        boolean success = drugService.removeById(12650472);
        System.out.println("Delete operation: " + (success ? "Success" : "Failed"));
    }

    @Test
    public void testInsertDrug() {
        // 测试新增药品记录
        // 1. 创建新药品对象
        // 2. 设置必填字段（注意非空约束）
        // 3. 自动填充createTime/updateTime字段
        // 4. 输出生成的主键ID
        Drug newDrug = new Drug();
        newDrug.setDrugName("测试药品");
        newDrug.setDrugInfo("测试药品信息");
        newDrug.setDrugEffect("测试疗效");
        newDrug.setDrugImg("default.jpg");  // 图片路径默认值
        newDrug.setPublisher("tester");
        newDrug.setCreateTime(new Date());  // INSERT时自动填充
        newDrug.setUpdateTime(new Date());  // UPDATE时自动填充

        drugService.save(newDrug);
        System.out.println("New drug saved. ID: " + newDrug.getDrugId());
    }
}

