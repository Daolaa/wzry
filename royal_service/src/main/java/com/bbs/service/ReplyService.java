package com.bbs.service;

import com.bbs.domain.Reply;

import java.util.List;

public interface ReplyService {
    /**
        根据评论ID查询评论回复
     */
    List<Reply> findReplyByCommentId(String commentId);

    /**
        根据评论ID 添加 评论的回复
     */
    void addReplyByCommentId(Reply reply);
}
