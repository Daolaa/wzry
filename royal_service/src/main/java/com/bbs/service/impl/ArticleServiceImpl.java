package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

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
