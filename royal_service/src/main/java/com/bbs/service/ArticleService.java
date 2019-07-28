package com.bbs.service;


import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {


    public List<Article> findByZoneId(Integer id);

    void save(Article article);

    Article findByArticleId(Integer articleId);

    List<Integer> countArticle();

    /**
     * 根据帖子标题查询帖子
     * @param title
     * @return
     */
    List<Article> findByTitle(String title);

    /**
     * 查询全部帖子
     * @return
     */
    List<Article> findAll();

    /**
     * 根据帖子id屏蔽帖子
     * @param articleId
     */
    void deleteByArticleId(Integer articleId);

    /**
     * 根据贴子ID修改置顶状态
     * @param isTop
     * @param id
     * @return
     */
    void updateByArticleId(Integer isTop, Integer id);

    /**
     * 根据帖子id查询帖子信息
     * @param articleId
     * @return
     */
    Article findByArticle(Integer articleId);

}
