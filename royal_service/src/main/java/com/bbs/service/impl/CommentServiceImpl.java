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
}
