package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"张三","123456","zhangsan@163.com"));
    }
    @Test
    public void queryByName() {
        User user = userDao.queryUserByUsername("张三1");
        System.out.println(user);
        if (user == null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名不可用");
        }
    }
    @Test
    public void queryByNameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("张三", "123456");
        if (user == null){
            System.out.println("登陆失败");
        }else {
            System.out.println("登陆成功");
        }
    }

}
