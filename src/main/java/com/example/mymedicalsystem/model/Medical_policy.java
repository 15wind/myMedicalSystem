package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "medical_policy", autoResultMap = true)
public class Medical_policy {
    @TableId(value = "id",type = IdType.ASSIGN_ID) //雪花算法生成id
    private Long id;
    @TableField("title")
    private String title;
    @TableField("message")
    private String message;
    @TableField(value = "city_id")
    private Long city_id;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date update_time;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date create_time;

}