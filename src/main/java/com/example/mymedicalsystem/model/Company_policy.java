package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("company_policy")
public class Company_policy {
    @TableId(value = "id",type = IdType.ASSIGN_ID) //雪花算法生成id
    private Long id;
    @TableField("title")
    private String title;
    @TableField("massage")
    private String massage;
    @TableField("company_id")
    private long company_id;
    @TableField(value = "update_time", fill = FieldFill.INSERT)
    private Date create_time;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date update_time;
}
