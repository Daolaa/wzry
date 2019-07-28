package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //登录
    @Override
    public User login(String username, String password) {
        return userDao.findByUserNameAndPassword(username, password);
    }
    //注册
    @Override
    public void userRegist(User user) {
        userDao.addUser(user);
    }
    @Override
    public User findUserByuserName(String username){
        return userDao.findByUserName(username);
    }
}
