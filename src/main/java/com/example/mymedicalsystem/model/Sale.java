package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sale")
public class Sale {
    @TableId("sale_id")
    private Long saleId;

    @TableField("sale_name")
    private String saleName;

    @TableField("sale_phone")
    private String salePhone;

    @TableField(value = "createtime", fill = FieldFill.INSERT)  // 只在插入时填充
    private Date createtime;

    @TableField(value = "updatetime", fill = FieldFill.INSERT_UPDATE)  // 插入和更新时填充
    private Date updatetime;
}