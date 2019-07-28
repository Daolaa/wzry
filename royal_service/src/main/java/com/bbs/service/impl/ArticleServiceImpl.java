package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.bbs.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 在后台帖子管理中 查询所有帖子
     * @return
     */
    @Override
    public List<Article> findAll(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return articleDao.findAll();
    }

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

    /*
        统计帖子数
     */
    @Override
    public List<Integer> countArticle() {

        List<Integer> list = new ArrayList<>();
        list.add(articleDao.countArticle());//添加总帖子数

        //获取今日发帖数
        int count = 0; //统计今日发帖数

        String nowTime = DateUtils.date2String(new Date(), "yyyy-MM-dd");

        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            String sendTime = DateUtils.date2String(article.getSendTime(), "yyyy-MM-dd");
            if (nowTime.equals(sendTime)) {
                count++;
            }
        }

        list.add(count);//添加今日发帖数
        return list;
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleDao.findBYTitle(title);
    }

    @Override
    public List<Article> findAll() {
        //就是此静态方法！ 必须写在调用dao层查询的语句上
        //PageHelper.startPage(currentPage,rows);
        List<Article> articleList = articleDao.finfAll();
        return articleList;
    }

    @Override
    public void deleteByArticleId(Integer articleId) {
        articleDao.deleteByArticleId(articleId);
    }

    @Override
    public void updateByArticleId(Integer isTop, Integer articleId) {
        articleDao.updateByArticleId(isTop,articleId);
    }

    @Override
    public Article findByArticle(Integer articleId) {
        return articleDao.findByArticle(articleId);
    }

    /**
     * 修改指定状态
     * @param article
     */
    @Override
    public void changeStatus(Article article) {
        articleDao.changeStatus(article);
    }

    /**
     * 删除帖子
     * @param articleId
     */
    @Override
    public void deleteArticle(Integer articleId){
        articleDao.deleteArticle(articleId);
    }

    /**
     * 根据条件查询
     * @param article
     * @return
     */
    @Override
    public List<Article> findByCondition(Article article,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return articleDao.findByCondition(article);
    }

    @Override
    public int countArticleByuserName(String userName) {
        return articleDao.countArticleByuserName(userName);

    }
}
