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

    /**
     * 更新邮箱
     * @param email
     */
    @Update("UPDATE  bbs_user_table SET email = #{email} WHERE userName = #{username}")
    void updataEmail(@Param("email") String email, @Param("username") String username);

    /**
     * 更新头像
     * @param picUrl
     */
    @Update("UPDATE  bbs_user_table SET picUrl = #{picUrl} WHERE userName = #{username}")
    void updataPriURL(@Param("picUrl")String picUrl,@Param("username")String username);

    /**
     * 根据用户名修改密码
     * @param username
     * @param newPsd
     */

    @Update("UPDATE  bbs_user_table SET userPass = #{password} WHERE userName = #{username}")
    void updataPsd(@Param("username") String username, @Param("password") String newPsd);

    /**
     * 修改角色
     * @param userName
     */
    @Select("UPDATE  bbs_user_table SET role = #{role} WHERE userName = #{username}")
    void updataRole(@Param("username") String userName,@Param("role")String role);


}
