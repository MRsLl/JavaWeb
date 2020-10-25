package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user == null){
            return false;
        }
        return true;
    }
}
