package com.bbs.manage.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage_User")
public class Manage_UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByCondition.do")
    public ModelAndView findByCondition(User user , Integer pageNum){
        ModelAndView mv = new ModelAndView();
        List<String> conditionList = new ArrayList<String>();
        String userName = user.getUserName();
        if(userName!=null && userName != ""){
            conditionList.add(userName);
            user.setUserName("%"+userName+"%");

        }
        Integer role = user.getRole();
        if(role !=null && role != 0){
        conditionList.add(String.valueOf(user.getRole()));
        }
        List<User> articleList = userService.findByCondition(user,pageNum,5);

        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("UserMsgs",pageInfo);
        mv.addObject("conditionList",conditionList);
        mv.setViewName("UserPage");
        return mv;
    }

    @RequestMapping("/upgrade.do")
    public ModelAndView upgrade(User user, Integer pageNum){
        userService.upgrade(user.getUserId());

        return findByCondition(user,pageNum);
    }

    @RequestMapping("/changeTalkStatus.do")
    public ModelAndView changeTalkStatus(User user, Integer pageNum){
        userService.changeTalkStatus(user);

        return findByCondition(user,pageNum);
    }

    @RequestMapping("/loginFailure")
    public ModelAndView loginFailure(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg","用户名或密码错误");
        mv.setViewName("login");
        return mv;
    }
}
