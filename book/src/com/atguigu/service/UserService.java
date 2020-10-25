package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 验证用户名是否可用
     * @param username
     */
    public boolean existUsername(String username);
}
