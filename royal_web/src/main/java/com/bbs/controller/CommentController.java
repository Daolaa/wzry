package com.bbs.controller;

import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment.do")
    public void addComment(Comment comment){
        //未验证登录
        //设置提交时间
        comment.setCommentTime(new Date());
        comment.setCommentUserName("admin");//写死了 后续修改
        comment.setCommentStatus(0);//设置初始为0 表示解除
        commentService.addComment(comment);
    }
}
