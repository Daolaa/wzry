package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    /**
     * 通过帖子ID查询对应的评论 多表查询 查回复
     * @param articleId
     * @return
     */
    @Select("select * from bbs_comment_table where articleId = #{articleId}")
    @Results(id = "comment_reply",value = {
            @Result(id = true,property = "commentId",column = "commentId"),
            @Result(property = "replies",column = "commentId",javaType = java.util.List.class,
            many = @Many(select = "com.bbs.dao.ReplyDao.findByCommentId"))
    })
    List<Comment> findByArticleId(Integer articleId);
}
