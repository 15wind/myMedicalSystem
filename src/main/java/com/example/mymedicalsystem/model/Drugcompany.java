package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "drugcompany", autoResultMap = true)
public class Drugcompany {
    @TableId("company_id")
    private Long id;
    @TableField("company_name")
    private String name;
    @TableField("company_phone")
    private String phone;
    @TableField(value = "updatetime", fill = FieldFill.UPDATE)
    private Date updatetime;
    @TableField(value = "createtime", fill = FieldFill.INSERT)
    private Date createtime;

}