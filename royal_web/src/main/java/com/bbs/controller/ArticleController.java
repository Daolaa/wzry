package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加帖子
     * @param article
     */
    @RequestMapping("/save.do")
    @ResponseBody
    public Integer save(Article article, HttpServletRequest request){
//        String userName = (String) request.getSession().getAttribute("userName");
        article.setSenderName("高高");
        Date date = new Date();
        article.setSendTime(date);
        article.setIsTop(0);
        article.setReplyCount(0);
        article.setUpvoteCount(0);
        article.setBrowseCount(0);
        article.setIsReport(0);
        articleService.save(article);
        Integer articleId = article.getArticleId();
        System.out.println(articleId);
        return articleId;
    }
    /**
     * 查询帖子的详情
     * @param articleId
     * @return
     */
    @RequestMapping("/findByArticleId.do")
    @ResponseBody
    public Article findByArticleId(String articleId){
        int _articleId = Integer.parseInt(articleId);
        return articleService.findByArticleId(_articleId);
    }
    /**
     * 通过区域id查找帖子
     * @param zoneId
     * @return
     */
    @RequestMapping("/findByZoneId.do")
    @ResponseBody
    public List<Article> findByZoneId(String zoneId){
        int _id = Integer.parseInt(zoneId);
        return articleService.findByZoneId(_id);

    }
}
