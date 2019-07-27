package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
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

    /*
        统计帖子数
     */
    @Override
    public List<Integer> countArticle() {

        List<Integer> list = new ArrayList<>();
        list.add(articleDao.countArticle());//添加总帖子数

        //获取今日发帖数
        int count = 0; //统计今日发帖数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = simpleDateFormat.format(new Date());//当期日期

        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            String sendTime = simpleDateFormat.format(article.getSendTime());
            if (nowTime.equals(sendTime)){
                count++;
            }
        }


        list.add(count);//添加今日发帖数
        return list;

    }
}
