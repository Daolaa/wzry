package com.bbs.controller;

import com.bbs.domain.Report;
import com.bbs.domain.User;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 添加举报内容
     * @param report
     */
    @RequestMapping("/addReport.do")
    public String addReport(Report report, HttpServletRequest request){
        //获取举报人
        User user = (User) request.getSession().getAttribute("user");
        report.setReportUserName(user.getUserName());
        //设置举报时间
        report.setReportTime(new Date());
        //设置举报状态
        report.setReportStatus(0);
        reportService.addReport(report);
        Integer articleId =report.getArticleId();
        return "redirect:/html/getArticle.html?articleId="+articleId;
    }
}
