package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 通过区域id查找帖子
     * @param id
     * @return
     */
    @Override
    public List<Article> findByZoneId(Integer id) {
        return articleDao.findByZoneId(id);

    }
    /**
     * 添加帖子
     * @param article
     */
    @Override
    public void save(Article article) {
       articleDao.save(article);
    }
    /**
     * 查询帖子的详情
     * @param articleId
     * @return
     */
    @Override
    public Article findByArticleId(Integer articleId) {
        return articleDao.findByArticleId(articleId);
    }
}
