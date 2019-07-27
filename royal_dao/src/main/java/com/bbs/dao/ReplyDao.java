package com.bbs.dao;

import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
    /**
        根据评论ID查询评论回复
     */
    @Select("SELECT * FROM bbs_reply_table WHERE commentId = #{commentId}")
    List<Reply> findReplyByCommentId(String commentId);


    /**
        根据评论ID 添加 评论的回复
     */
    @Insert("INSERT INTO bbs_reply_table VALUES(#{replyId},#{replyContent},#{replyTime},#{replyUserName},#{commentId})")
    void addReplyByCommentId(Reply reply);
}
