package cn.itcast;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage")
public class UserController {
    @Autowired
    private UserService userService;

    //后台登陆
    @RequestMapping("/login")
    public String manage(@RequestParam("userName") String username, @RequestParam("userPass") String userpass, HttpSession session) {
        User user = userService.login(username, userpass);
        if (user != null) {//登陆成功
            session.setAttribute("manage", user);
            return "/jsp/main";
        } else {
            return "/jsp/error";
        }
    }
}
