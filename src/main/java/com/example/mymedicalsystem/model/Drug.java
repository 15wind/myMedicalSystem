package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("drug")
public class Drug {
    // 药品 ID，手动处理生成逻辑，这里先定义为 Long 类型
    @TableId("drug_id")
    private Long drugId;
    @TableField("drug_name")
    private String drugName;
    @TableField("drug_info")
    private String drugInfo;
    @TableField("drug_effect")
    private String drugEffect;
    @TableField("drug_img")
    private String drugImg;
    @TableField("createtime")
    private Date createtime;
    @TableField("updatetime")
    private Date updatetime;
    @TableField("publisher")
    private String publisher;
}