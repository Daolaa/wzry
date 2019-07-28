package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入userService
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
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

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }
    /**
     * 查询用户信息
     * @return
     */
    @RequestMapping("/findUserById.do")
    @ResponseBody
    public  User findUserById(){
        //可以在域中获取 不查了
        User user = new User();
        user.setUserName("admin");
        return user;
    }

    /**
     * 更新当前登录用户的邮箱或者头像
     * @param email
     * @param picUrl
     * @return
     */

    @RequestMapping("/updataEmailAndPriURL.do")
    public String updataEmailAndPriURL(String username, String email, MultipartFile picUrl, HttpServletRequest request) throws IOException {

        //获取文件路径
        String path = request.getSession().getServletContext().getRealPath("images");

        //创建目录
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取文件名
        String picUrlName = picUrl.getOriginalFilename();
        //弄一个唯一标识 uuid
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        picUrlName = uuid+"_"+picUrlName;

        //上传文件
        picUrl.transferTo(new File(file,picUrlName));

        String picUr = "/images/"+picUrlName;

        userService.updataEmailAndPriURL(email,picUr,username);

        return "redirect:/html/user_info.html";
    }

    /**
     * 修改密码
     * @param password
     * @param newPsd
     */
    @RequestMapping("/updataPsd.do")
    @ResponseBody
    public boolean updataPsd(String username,String password,String newPsd){
        return userService.updataPsd(username,password,newPsd);
    }

    @RequestMapping("/updataRole.do")
    @ResponseBody
    public boolean updataRole(String articleNum){
        //写死了
        String username = "admin";
        return userService.updataRole(articleNum,username);
    }

}
