package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("city")
public class City {
    @TableId(value = "city_id", type = IdType.ASSIGN_ID)
    private Long cityId;

    @TableField("createtime")
    private Date createtime;

    @TableField("updatetime")
    private Date updatetime;

    @TableField("city_number")
    private Integer cityNumber;
}