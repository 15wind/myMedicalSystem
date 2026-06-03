package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("account") // 映射数据库表名
public class Account {
    @TableId(value = "id", type = IdType.INPUT) // 主键，手动输入
    private Long id;

    @TableField("realname") // 真实姓名
    private String realname;

    @TableField("uname") // 用户名（对应数据库字段uname）
    private String username; // 代码中使用驼峰命名，通过@TableField指定数据库字段

    @TableField("pwd") // 密码（加密存储）
    private String pwd;

    @TableField("phonenumber") // 手机号
    private String phonenumber;

    @TableField("utype") // 用户类型（ROLE_1: 医师, ROLE_2: 管理员）
    private String utype;

    @TableField(value = "createtime", fill = FieldFill.INSERT) // 插入时自动填充时间
    private Date createTime;

    @TableField(value = "updatetime", fill = FieldFill.UPDATE) // 更新时自动填充时间
    private Date updateTime;
}