package com.bbs.service.impl;

import com.bbs.dao.CommentDao;
import com.bbs.domain.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void addComment(Comment comment) {
        commentDao.AddComment(comment);
    }

    /**
     * 根据贴子ID 统计评论数
     * @param articleId
     * @return
     */
    @Override
    public int countCommentById(int articleId) {
        return commentDao.countCommentById(articleId);
    }
}
