package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findByZoneId(Integer id);

    void save(Article article);

    Article findByArticleId(Integer articleId);
}
