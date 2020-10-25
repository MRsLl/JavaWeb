package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 向数据库中保存用户
     * @return
     */
    public int saveUser(User user);

    /**
     * 通过用户名查找用户
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return 登陆时，若返回null则登录失败，若返回值不为null则登陆成功
     */
    public User queryUserByUsernameAndPassword(String username,String password);
}
