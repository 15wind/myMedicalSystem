//package com.example.mymedicalsystem;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class MyMedicalSystemApplicationTests {
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void test1() {
//        List<User> users = userService.list();
//        users.forEach(System.out::println);
//        System.out.println(userService.count());
//    }
//    @Test
//    public void test2(){
//        User user = userService.getById(1);
//        System.out.println(user);
//    }
//    @Test
//    public void test3(){
//        //map集合中定义的是要查询的列，根据哪个列来查
//        Map<String, Object> map = new HashMap<>(){{
//            put("realname","王小明");
//            put("uname","王小明4125");
//        }};
//        List<User> users = userService.listByMap(map);
//        users.forEach(System.out::println);
//    }
//    @Test
//    public void test4(){
//        //删除之后没法恢复
//        boolean b = userService.removeById(2);
//        System.out.println(b);
//    }
//    @Test
//    public void test5() {
//        //插入新数据，插入相同数据会报错
//        User user = new User();
//        user.setUName("SS");
//        user.setPwd("ss");
//        user.setCreatetime(new Date());
//        user.setUpdatetime(new Date());
//        userService.save(user);
//    }
//
//
//}
