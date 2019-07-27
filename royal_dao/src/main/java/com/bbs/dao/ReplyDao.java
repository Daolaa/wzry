package com.bbs.dao;

import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {

    /**
     * 通过评论id查询对应的回复
     * @param commentId
     * @return
     */
    @Select("select * from bbs_reply_table where commentId = #{commentId}")
    List<Reply> findByCommentId(Integer commentId);
}
