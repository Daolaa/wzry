package com.bbs.service;

import com.bbs.domain.User;

import java.util.List;

public interface UserService {
    // 通过用户名及密码核查用户登录
    User login(String username, String password);
    //用户注册
    void userRegist(User user);

    //增加用户
    User findUserByuserName (String username);

    List<User> findAll();

}
