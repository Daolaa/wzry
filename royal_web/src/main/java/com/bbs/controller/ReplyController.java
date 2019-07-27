package com.bbs.controller;

import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    /*
        根据评论ID 查询 评论的回复
     */
    @RequestMapping("/findReplyByCommentId.do")
    public List<Reply> findReplyByCommentId(String commentId){
        return replyService.findReplyByCommentId(commentId);
    }

    /*
        根据评论ID 添加 评论的回复
     */

    @RequestMapping("/addReplyByCommentId.do")
    public String  addReplyByCommentId(Reply reply , HttpServletRequest request){
        //添加回复时间
        reply.setReplyTime(new Date());
        //添加回复用户 从session域获取
        reply.setReplyUserName("战神");
        replyService.addReplyByCommentId(reply);


        return "redirect:";
    }
}
