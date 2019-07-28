package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //登录
    @Select("select * from bbs_user_table where userName=#{userName} and userPass=#{userPass}")
    User findByUserNameAndPassword(@Param("userName")String userName, @Param("userPass")String userPass);

    //注册
    @Select("insert into bbs_user_table(userId,userName,userPass,email,picUrl,role,lastLoginTime,loginStatus,talkStatus,isupdating,updateStatus) values(#{userId},#{userName},#{userPass},#{email},#{picUrl},#{role},#{lastLoginTime},#{loginStatus},#{talkStatus},#{isupdating},#{updateStatus})")
   void addUser(User user);

    //查询
    @Select("select * from bbs_user_table where userName=#{username}")
    User findByUserName (String username);

    @Select("select * from bbs_user_table")
    List<User> findAll();
}
