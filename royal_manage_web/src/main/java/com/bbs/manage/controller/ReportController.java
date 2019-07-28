package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 查询审批举报表
     * @return
     */
    @RequestMapping("/findByReport.do")
    public ModelAndView findAll(Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 5;
        }
        List<Report> report = reportService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(report);
        ModelAndView mv = new ModelAndView();
        mv.addObject("reportlist",pageInfo);
        mv.setViewName("report");
        return mv;
    }

    /**
     * 查询相关内容
     * @return
     */
    @RequestMapping("/findById.do")
    @ResponseBody
    public Article findById(String articleId){
        Article reports = reportService.findById(articleId);
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("report",reports);
        return reports;
    }

    /**
     * 更改为屏蔽状态
     * @return
     */
    @RequestMapping("/updateReport1.do")
    public ModelAndView updateReport1(String articleId,String reportId,Integer pageNum,Integer pageSize){
        reportService.updateReport1(articleId,reportId);
        return findAll(pageNum,pageSize);
    }

    /**
     * 解除屏蔽状态
     * @return
     */
    @RequestMapping("/updateReport0.do")
    public ModelAndView updateReport0(String articleId,String reportId,Integer pageNum,Integer pageSize){
        reportService.updateReport0(articleId,reportId);
        return findAll(pageNum,pageSize);
    }

    /**
     * 驳回
     * @param reportId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/deleteById.do")
    public ModelAndView deleteById(Integer reportId,Integer pageNum,Integer pageSize){
        reportService.deleteById(reportId);
        return findAll(pageNum,pageSize);
    }
}
