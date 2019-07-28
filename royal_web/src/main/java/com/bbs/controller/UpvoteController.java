package com.bbs.controller;

import com.bbs.domain.Upvote;
import com.bbs.domain.User;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 点赞
 */
@Controller
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    /**
     * 修改点赞状态
     * @param upvote
     */
    @RequestMapping("/addUpvote.do")
    @ResponseBody
    public boolean addUpvote(Upvote upvote, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        upvote.setUpvoteUserName(user.getUserName());//设置评论人
        upvoteService.addUpvote(upvote);
        return true;
    }

    /**
     * 根据贴子ID查询点赞数
     * @return
     */
    @RequestMapping("countUpvoteById.do")
    @ResponseBody
    public Integer countUpvoteById(String articleId){
        return upvoteService.countUpvoteById(Integer.parseInt(articleId));
    }


    /**
     * 更加贴子ID 和用户名查询点赞状态
     * @param articleId
     * @return
     */

    @RequestMapping("/isUpvote.do")
    @ResponseBody
    public Integer isUpvote(String articleId,HttpServletRequest request){
        //获取用户名
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUserName();

        //1:已赞 0:未查到点赞记录
        return upvoteService.findUpvoteByNameAndArticleId(articleId, username);
    }
}
