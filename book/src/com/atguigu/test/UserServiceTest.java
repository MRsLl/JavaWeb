package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void login(){
        User login = userService.login(new User(null, "张三", "123456", "null"));
        if (login == null){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null, "张三1", "123456", "zhangsan@163.com"));
    }

    @Test
    public void existUsername() {
        boolean existUsername = userService.existUsername("李四1");
        if (existUsername){
            System.out.println("用户名不可用");
        }else {
            System.out.println("用户名可用");
        }
    }
}
