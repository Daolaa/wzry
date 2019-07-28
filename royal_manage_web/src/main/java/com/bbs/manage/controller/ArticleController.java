package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findByPage.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.findAll();
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    @RequestMapping("/deleteArticle.do")
    public ModelAndView deleteArticle(Integer id) {
        articleService.deleteByArticleId(id);
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.findAll();
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }

    @RequestMapping("/changeStatus.do")
    public ModelAndView changeStatus(Integer id) {
        Article article = articleService.findByArticle(id);
        Integer isTop = article.getIsTop();
        if (isTop == 0) {
            isTop = 1;
        } else if (isTop == 1) {
            isTop = 0;
        }
        articleService.updateByArticleId(isTop, id);

        List<Article> articleList = articleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("articleList", articleList);
        mv.setViewName("ArticlePage");
        return mv;
    }


}
