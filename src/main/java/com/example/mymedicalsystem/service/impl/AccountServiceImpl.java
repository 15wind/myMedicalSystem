package com.example.mymedicalsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymedicalsystem.mapper.AccountMapper;
import com.example.mymedicalsystem.model.Account;
import com.example.mymedicalsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public boolean save(Account account) {
        // 检测数据库account表id的最大值
        List<Account> accounts = list();
        Long maxId = 0L;
        for (Account acc : accounts) {
            if (acc.getId() != null && acc.getId() > maxId) {
                maxId = acc.getId();
            }
        }
        // 生成新的id
        account.setId(maxId + 1);

        // 自动设置创建时间和更新时间
        Date now = new Date();
        account.setCreateTime(now);
        account.setUpdateTime(now);

        return super.save(account);
    }

    @Override
    public boolean updateById(Account account) {
        // 自动更新时间戳
        account.setUpdateTime(new Date());
        return super.updateById(account);
    }
}