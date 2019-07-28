package com.bbs.controller;

import com.bbs.domain.Upvote;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public boolean addUpvote(Upvote upvote){
        upvote.setUpvoteUserName("战神");//设置评论人
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
    public Integer isUpvote(String articleId){
        //获取用户名
        String username = "战神"; //数据写死了

        //1:已赞 0:未查到点赞记录
        return upvoteService.findUpvoteByNameAndArticleId(articleId, username);
    }
}
