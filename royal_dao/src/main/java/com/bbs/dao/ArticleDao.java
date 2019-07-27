package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    @Select("select * from bbs_article_table")
    List<Article> findAll();

    @Select("SELECT COUNT(1) FROM bbs_article_table")
    Integer countArticle();

}
