package com.bbs.service;

import com.bbs.domain.Article;
import com.bbs.domain.Report;

import java.util.List;

public interface ReportService {
    /**
     * 查询举报贴
     * @return
     */
    public List<Report> findAll(Integer pageNum,Integer pageSize);

    /**
     * 查询相关帖子
     * @return
     */
    public Article findById(String id);

    /**
     * 更改举报状态
     */
    public void updateReport1(String i,String j);

    /**
     *
     * 解除屏蔽状态
     */
    public void updateReport0(String i,String j);

    /**
     * 驳回
     */
    public void deleteById(Integer id);

    void addReport(Report report);
}
