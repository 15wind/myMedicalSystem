package com.example.mymedicalsystem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("drug_sale")
public class DrugSale {
    @TableId("id")
    private Long id;
    @TableField("drug_id")
    private Long drugId;
    @TableField("sale_id")
    private Long saleId;
    @TableField(exist = false)
    private Sale sale;
}