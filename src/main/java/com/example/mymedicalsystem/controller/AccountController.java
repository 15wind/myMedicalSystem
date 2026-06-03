package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Account;
import com.example.mymedicalsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/queryAccounts")
    public List<Account> queryAccounts() {
        List<Account> accountList = accountService.list();
        return accountList;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Account account) {
        Map<String, Object> result = new HashMap<>();
        try {
            accountService.save(account);
            result.put("success", true);
            result.put("message", "注册成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "注册失败：" + e.getMessage());
        }
        return result;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Account account) {
        Map<String, Object> result = new HashMap<>();
        try {
            accountService.updateById(account);
            result.put("success", true);
            result.put("message", "更新成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新失败：" + e.getMessage());
        }
        return result;
    }
}