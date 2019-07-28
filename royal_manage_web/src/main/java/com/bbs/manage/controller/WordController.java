package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordSerive;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordSerive wordSerive;

    /**
     * 查询所有的敏感词
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findAll(Integer pageNum,Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;
        }
        ModelAndView mv = new ModelAndView();
        List<Word> wordList = wordSerive.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(wordList);
        mv.addObject("wordList",pageInfo);
        mv.setViewName("WordPage");
        return mv;
    }

    @RequestMapping("/save.do")
    public ModelAndView saveWord(Word word,Integer pageNum,Integer pageSize){
        wordSerive.saveWord(word);
        ModelAndView mv = new ModelAndView();
        return findAll(pageNum,pageSize);
    }

    @RequestMapping("/changeStatus.do")
    public ModelAndView changeStatus(Word word,Integer pageNum,Integer pageSize){
        wordSerive.updateStatus(word);
        ModelAndView mv = new ModelAndView();
        return findAll(pageNum,pageSize);
    }


    @RequestMapping("/deleteWord.do")
    public ModelAndView deleteWord(Integer wordId,Integer pageNum,Integer pageSize){
        wordSerive.deleteStatus(wordId);
        ModelAndView mv = new ModelAndView();
        return findAll(pageNum,pageSize);
    }





}
