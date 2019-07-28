package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findByCondition(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findByCondition(user);
    }

    @Override
    public void upgrade(Integer userId) {
        userDao.upgrade(userId);
    }

    @Override
    public void changeTalkStatus(User user) {
        userDao.changeTalkStatus(user);
    }

    @Override
    public void updateUserLoginStatus(User userInfo) {
        userDao.updateUserLoginStatus(userInfo);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

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

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 用户登陆 权限校验用
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User userInfo = userDao.findByUsername(username);
        List<SimpleGrantedAuthority> authoritys = new ArrayList<SimpleGrantedAuthority>();
        if(userInfo.getRole() == 3){
            //把用户拥有的角色添加到容器
            authoritys.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        //将用户名 用户密码 赋值给校验的user对象
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userInfo.getUserName(),"{noop}"+userInfo.getUserPass(), true, true, true,true,authoritys);

        return user;

    }

    @Override
    public void updataEmailAndPriURL(String email, String picUrl,String username) {
        if (email != null && email.length()>0){
            userDao.updataEmail(email,username);
        }
        if (picUrl != null && picUrl.length()>0){
            userDao.updataPriURL(picUrl,username);
        }

    }

    @Override
    public boolean updataPsd(String username, String password, String newPsd) {
        User user = userDao.findByUserName(username);
        if (user !=null && password.equals(user.getUserPass())){
            //修改密码
            userDao.updataPsd(username,newPsd);
            return true;
        }
        return false;
    }

    @Override
    public boolean updataRole(String articleNum,String userName) {

        if (Integer.parseInt(articleNum) >= 5){
            String role = "2";
            userDao.updataRole(userName, role);
            return true;
        }
        return false;
    }
}
