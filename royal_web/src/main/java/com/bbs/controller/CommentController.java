package com.bbs.controller;

import com.bbs.domain.Comment;
import com.bbs.domain.User;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param comment
     */
    @RequestMapping("/addComment.do")
    public String addComment(Comment comment, HttpServletRequest request){
        //未验证登录
        //设置提交时间
        comment.setCommentTime(new Date());
        User user = (User) request.getSession().getAttribute("user");
        comment.setCommentUserName(user.getUserName());//
        comment.setCommentStatus(0);//设置初始为0 表示解除
        commentService.addComment(comment);
        Integer articleId = comment.getArticleId();
        return "redirect:/html/getArticle.html?articleId="+articleId;
    }

    /**
     * 根据贴子ID 统计评论数
     * @param articleId
     * @return
     */
    @RequestMapping("/countCommentById.do")
    @ResponseBody
    public int countCommentById(String articleId){
        return commentService.countCommentById(Integer.parseInt(articleId));
    }

}
