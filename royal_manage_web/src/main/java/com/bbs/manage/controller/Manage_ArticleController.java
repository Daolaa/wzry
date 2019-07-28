package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.ZoneService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage_Article")
public class Manage_ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ZoneService zoneService;

    /**
     * 查询所有帖子
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(Integer pageNum,Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;
        }
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.findAll(pageNum,pageSize);
        for (Article article : articleList) {
            String zoneName = zoneService.findZoneNameById(article.getZoneId());
            article.setZoneName(zoneName);
        }
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("articleMsgs",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

    @RequestMapping("/findByCondition.do")
    public ModelAndView findByCondition(Article article ,Integer pageNum){
        ModelAndView mv = new ModelAndView();
        List<String> conditionList = new ArrayList<String>();
        if(article.getTitle()!=null){
            conditionList.add(article.getTitle());
            article.setTitle("%"+article.getTitle()+"%");

        }
        if(article.getSenderName()!=null){
            conditionList.add(article.getSenderName());
            article.setSenderName("%"+article.getSenderName()+"%");

        }

        List<Article> articleList = articleService.findByCondition(article,pageNum,5);
        for (Article article1 : articleList) {
            String zoneName = zoneService.findZoneNameById(article1.getZoneId());
            article1.setZoneName(zoneName);
        }
        PageInfo pageInfo = new PageInfo(articleList);
        mv.addObject("articleMsgs",pageInfo);
        mv.addObject("conditionList",conditionList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    /**
     * 修改置顶状态
     * @param article
     * @param pageNum
     * @return
     */
    @RequestMapping("/changeStatus.do")
    public ModelAndView changeStatus(Article article, @Param("pageNum") Integer pageNum){
        articleService.changeStatus(article);
        return findByCondition(article,pageNum);
    }

    /**
     * 删除帖子
     * @param article
     * @param pageNum
     * @return
     */
    @RequestMapping("/deleteArticle.do")
    public ModelAndView deleteArticle(Article article,@Param("pageNum") Integer pageNum){
        Integer articleId = article.getArticleId();
        articleService.deleteArticle(articleId);

        return findByCondition(article,pageNum);
    }
}
