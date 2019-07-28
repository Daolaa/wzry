package com.bbs.service;

import com.bbs.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findByCondition(User user, Integer pageNum, Integer pageSize);

    void upgrade(Integer userId);

    void changeTalkStatus(User user);

    void updateUserLoginStatus(User userInfo);

    User findByUsername(String username);

    //登录

    public User login(String username, String password);

    //注册
    public void userRegist(User user);


    public User findUserByuserName(String username);


    public List<User> findAll();

    void updataEmailAndPriURL(String email,String picUrl,String username);

    boolean updataPsd(String username, String password, String newPsd);

    boolean updataRole(String articleNum,String userName);
}
