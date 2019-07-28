package com.bbs.dao;

import com.bbs.domain.Upvote;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteDao {

    /**
     * 根据用户名和帖子ID添加点赞数
     * @param
     */

    @Insert("INSERT INTO bbs_upvote_table VALUES(#{upvoteUserName},#{upvoteArticleId},#{isUpvote});")
    public void addUpvote(Upvote upvote);

    /**
     * 根据用户名和帖子ID 删除点赞
     * @param upvote
     */
    @Delete("DELETE FROM bbs_upvote_table WHERE upvoteUsername = #{upvoteUserName} AND upvoteArticleId = #{upvoteArticleId}")
    void deleteUpvote(Upvote upvote);

    /**
     * 根据用户名和帖子ID查询点赞
     */
    @Select("SELECT * FROM bbs_upvote_table WHERE upvoteArticleId = #{articleId} and upvoteUsername = #{userName} ")
    Upvote findUpvoteByNameAndArticleId(@Param("articleId") String articleId , @Param("userName") String userName);

    /**
     * 根据用户名和帖子ID 修改点赞状态
     * @param upvote
     */
    @Update("UPDATE  bbs_upvote_table SET isUpvote = #{isUpvote} WHERE upvoteArticleId = #{upvoteArticleId} AND upvoteUserName = #{upvoteUserName}")
    void updateUpvote(Upvote upvote);

    /**
     * 根据贴子ID查询点赞数
     * @param articleId
     * @return
     */
    @Select("SELECT COUNT(1) FROM bbs_upvote_table WHERE upvoteArticleId = #{articleId}")
    int countUpvoteById(int articleId);
}
