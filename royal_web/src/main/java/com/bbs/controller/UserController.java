package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入userService
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(@RequestParam("userName") String username, @RequestParam("userPass") String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "user_info";
        } else {
            return "login_error";
        }
    }

    /**
     * 账户校验
     */
    @PostMapping("/exist")
    @ResponseBody
    public String exist(String existname) {
        User user = userService.findUserByuserName(existname);
        if (user != null) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 用户注册
     */
    @RequestMapping("/regist")
    public String register(User user, HttpServletRequest request) throws Exception {
        String username = user.getUserName();
        // 如果数据库中没有该用户，可以注册，否则跳转页面
        user.setTalkStatus(0);
        user.setRole(1);
        if (userService.findUserByuserName(username) == null) {
            // 添加用户
            userService.userRegist(user);
            request.getSession(true).setAttribute("user", user);
            // 注册成功跳转到主页面
            return "user_info";
        } else {
            // 注册失败跳转到错误页面
            return "regist_error";
        }

    }

    //退出
    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "index";
    }

    /**
     * 跳转个人信息页面
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    /**
     * 跳转个人信息页面
     */
    @RequestMapping("/person")
    public String person() {
        return "user_info";
    }

    /**
     * 跳转修改密码页面
     */
    @RequestMapping("/psw")
    public String psw() {
        return "user_pwd";
    }

    /**
     * 跳转申请高级用户页面
     */
    @RequestMapping("/apply")
    public String apply() {
        return "user_apply";
    }
}
