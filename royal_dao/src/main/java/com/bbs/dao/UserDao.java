package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    /**
     * 查询用户 带分页
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    /**
     * 用户升级
     * @param userId
     */
    @Update("update bbs_user_table set role = 2,updateStatus = 1 where userId = #{userId}")
    void upgrade(Integer userId);

    /**
     * 用户禁言状态
     * @param user
     */
    void changeTalkStatus(User user);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from bbs_user_table where userName = #{username}")
    User findByUsername(String username);

    /**
     * 修改用户登陆状态
     * @param userInfo
     */
    void updateUserLoginStatus(User userInfo);
}
