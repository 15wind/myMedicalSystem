package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("doctor_level")
public class Doctor_level {
    @TableId(value = "id",type = IdType.ASSIGN_ID) //雪花算法生成id
    private Long id;
    @TableField("name")
    private String name;
}
