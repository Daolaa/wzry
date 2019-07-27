package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {

        @Insert("insert into bbs_comment_table values(#{commentId},#{commentContent},#{commentTime},#{commentUserName},#{commentStatus},#{articleId})")
    void AddComment(Comment comment);
}
