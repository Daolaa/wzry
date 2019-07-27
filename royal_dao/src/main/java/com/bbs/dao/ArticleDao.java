package com.bbs.dao;

import com.bbs.domain.Article;

import org.apache.ibatis.annotations.*;

import org.apache.ibatis.annotations.Select;
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


}
