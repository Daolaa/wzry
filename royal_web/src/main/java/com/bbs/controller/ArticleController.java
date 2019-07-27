package com.bbs.controller;

import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /*
        发帖数统计
     */
    @RequestMapping("/countArticle.do")
    public List<Integer> countArticle(){
        return articleService.countArticle();
    }
}
