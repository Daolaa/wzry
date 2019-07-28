package com.bbs.service;


import com.bbs.domain.Comment;

public interface CommentService {

    void addComment(Comment comment);

    int countCommentById(int articleId);
}
