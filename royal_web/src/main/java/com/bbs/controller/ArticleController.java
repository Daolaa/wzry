package com.bbs.controller;

import com.bbs.domain.Article;
import com.bbs.domain.User;
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
        User user = (User) request.getSession().getAttribute("user");
        article.setSenderName(user.getUserName());
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

        return articleService.findByArticleId(Integer.parseInt(articleId));
    }
    /**
     * 通过区域id查找帖子
     * @param zoneId
     * @return
     */
    @RequestMapping("/findByZoneId.do")
    @ResponseBody
    public List<Article> findByZoneId(String zoneId) {
        int _id = Integer.parseInt(zoneId);
        return articleService.findByZoneId(_id);
    }

    /*
        发帖数统计
     */
    @RequestMapping("/countArticle.do")
    @ResponseBody
    public List<Integer> countArticle(){
        return articleService.countArticle();

    }

    /**
     * 统计用户发帖数
     * @return
     */
    @RequestMapping("/countArticleByuserName.do")
    @ResponseBody
    public Integer countArticleByuserName(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        return articleService.countArticleByuserName(userName);
    }

    @RequestMapping("/findByTitle")
    @ResponseBody
    public List<Article> findByTitle(HttpServletRequest request){
        String title = request.getParameter("sou");
        return articleService.findByTitle("%"+title+"%");
    }

}
