package com.bbs.service.impl;

import com.bbs.dao.ReplyDao;
import com.bbs.domain.Reply;
import com.bbs.service.ReplyService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;
    /**
        根据评论ID查询评论回复
     */
    @Override
    public List<Reply> findReplyByCommentId(String commentId) {
        return replyDao.findReplyByCommentId(commentId);
    }

    /**
        根据评论ID 添加 评论的回复
     */
    @Override
    public void addReplyByCommentId(Reply reply) {
        replyDao.addReplyByCommentId(reply);
    }
}
