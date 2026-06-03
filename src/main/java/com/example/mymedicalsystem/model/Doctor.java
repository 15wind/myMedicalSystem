package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "doctor", autoResultMap = true)
public class Doctor {
    @TableId(value = "id", type = IdType.NONE) // 不使用自动生成ID，改为手动控制
    private Long id;
    @TableField("name")
    private String name;
    @TableField("age")
    private int age;
    @TableField("sex")
    private String sex;
    @TableField("level_id")
    private long level_id;
    @TableField("phone")
    private String phone;
    @TableField("type_id")
    private long type_id;
    @TableField("hospital")
    private String hospital;
    @TableField("updatetime")
    private Date updatetime;
    @TableField("createtime")
    private Date createtime;
    @TableField("account_id")
    private long account_id;
}



