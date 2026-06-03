
package com.example.mymedicalsystem.controller;

import com.example.mymedicalsystem.model.Doctor;
import com.example.mymedicalsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/queryDoctors")
    public List<Doctor> queryDoctors() {
        List<Doctor> doctorList = doctorService.list();
        return doctorList;
    }

    @PostMapping("/addDoctor")
    public Result addDoctor(@RequestBody Doctor doctor) {
        boolean success = doctorService.save(doctor);
        if (success) {
            return Result.success(doctor);
        }
        return Result.error("添加医生失败");
    }

    @PutMapping("/updateDoctor")
    public Result updateDoctor(@RequestBody Doctor doctor) {
        boolean success = doctorService.updateById(doctor);
        if (success) {
            return Result.success();
        }
        return Result.error("更新医生失败");
    }

    @DeleteMapping("/{id}")
    public Result deleteDoctor(@PathVariable Long id) {
        boolean success = doctorService.removeById(id);
        if (success) {
            return Result.success();
        }
        return Result.error("删除医生失败");
    }

    @PutMapping("/resetPassword/{id}")
    public Result resetPassword(@PathVariable Long id) {
        // 实际项目中应该实现密码重置逻辑
        return Result.success();
    }

    // 统一返回结果类
    static class Result {
        private boolean success;
        private String message;
        private Object data;

        private Result(boolean success, String message, Object data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public static Result success() {
            return new Result(true, "操作成功", null);
        }

        public static Result success(Object data) {
            return new Result(true, "操作成功", data);
        }

        public static Result error(String message) {
            return new Result(false, message, null);
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public Object getData() {
            return data;
        }
    }
}
