package com.bbs.dao;

import com.bbs.domain.Article;

import org.apache.ibatis.annotations.*;

import org.apache.ibatis.annotations.Select;
import com.bbs.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    /**
     * 通过区域id查找帖子
     * @param id
     * @return
     */
    @Select("select * from bbs_article_table where zoneId = #{id}")
    public List<Article> findByZoneId(Integer id);

    /**
     * 查询帖子的详情 多表查询 查评论
     * @param articleId
     * @return
     */
    @Select("select * from bbs_article_table where articleId = #{articleId}")
    @Results(id="article_comment",value = {
            @Result(id = true,property = "articleId",column = "articleId"),
            @Result(property = "comments",column = "articleId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.findByArticleId"))
    })
    public Article findByArticleId(Integer articleId);

    /**
     * 添加帖子
     * @param article
     */
    @Insert("insert into bbs_article_table(title,content,sendTime,senderName,isTop,replyCount," +
            "upvoteCount,browseCount,zoneId,isReport) values(#{title},#{content},#{sendTime},#{senderName}," +
            "#{isTop},#{replyCount},#{upvoteCount},#{browseCount},#{zoneId},#{isReport})")
    @Options(useGeneratedKeys=true,keyColumn="articleId",keyProperty = "articleId")
    void save(Article article);

    /**
     * 查询所有帖子
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> findAll();

    /**
     * 统计所有帖子
     * @return
     */
    @Select("SELECT COUNT(1) FROM bbs_article_table")
    Integer countArticle();



    /**
     * 根据帖子标题查询帖子
     * @param title
     * @return
     */
    @Select("select * from bbs_article_table where title like #{title}")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "sendTime", column = "sendTime"),
            @Result(property = "senderName", column = "senderName"),
            @Result(property = "isTop", column = "isTop"),
            @Result(property = "replyCount", column = "replyCount"),
            @Result(property = "upvoteCount", column = "upvoteCount"),
            @Result(property = "browseCount", column = "browseCount"),
            @Result(property = "zoneId", column = "zoneId"),
            @Result(property = "isReport", column = "isReport"),
            @Result(property = "comments",column = "articleId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.findByArticleId"))
    })
    public List<Article> findBYTitle(String title);

    /**
     * 查询全部帖子
     * @return
     */
    @Select("select * from bbs_article_table")
    @Results({
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "sendTime", column = "sendTime"),
            @Result(property = "senderName", column = "senderName"),
            @Result(property = "isTop", column = "isTop"),
            @Result(property = "replyCount", column = "replyCount"),
            @Result(property = "upvoteCount", column = "upvoteCount"),
            @Result(property = "browseCount", column = "browseCount"),
            @Result(property = "zoneId", column = "zoneId"),
            @Result(property = "isReport", column = "isReport"),
            @Result(property = "comments",column = "articleId",javaType = java.util.List.class,
                    many = @Many(select = "com.bbs.dao.CommentDao.findByArticleId"))
    })
    List<Article> finfAll();

    /**
     * 根据帖子id屏蔽帖子
     * @param articleId
     */
    @Delete("delete from bbs_article_table where articleId = #{articleId}")
    public void deleteByArticleId(Integer articleId);

    /**
     * 根据贴子ID修改置顶状态
     * @param isTop
     * @param articleId
     * @return
     */
    @Update("update bbs_article_table isTop = #{isTop} where articleId = #{articleId}")
    public void updateByArticleId(Integer isTop, Integer articleId);

    /**
     * 根据帖子id查询帖子信息
     * @param articleId
     * @return
     */
    @Select("select * from bbs_article_table where articleId= #{articleId}")
    public Article findByArticle(Integer articleId);
}
