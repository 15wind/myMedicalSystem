package com.example.mymedicalsystem.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FillDateHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // Sale 模型的字段（createtime, updatetime）
        this.strictInsertFill(metaObject, "createtime", Date::new, Date.class);
        this.strictInsertFill(metaObject, "updatetime", Date::new, Date.class);

        // 其他模型的通用字段（如果有）
        this.strictInsertFill(metaObject, "createTime", Date::new, Date.class);
        this.strictInsertFill(metaObject, "updateTime", Date::new, Date.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // Sale 模型的字段（updatetime）
        this.strictUpdateFill(metaObject, "updatetime", Date::new, Date.class);

        // 其他模型的通用字段（如果有）
        this.strictUpdateFill(metaObject, "updateTime", Date::new, Date.class);
    }
}