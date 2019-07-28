package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Article;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    /**
     * 查询审批审批举报
     * @return
     */
    @Override
    public List<Report> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return reportDao.findAll();
    }

    /**
     * 查询相关内容
     * @return
     */
    @Override
    public Article findById(String id) {
        return reportDao.findById(Integer.parseInt(id));
    }

    /**
     * 更改举报状态
     */
    @Override
    public void updateReport1(String article,String reportId) {
        reportDao.updateReport1(Integer.parseInt(article));
        reportDao.updateById1(Integer.parseInt(reportId));
    }

    /**
     * 解除屏蔽状态
     */
    @Override
    public void updateReport0(String article,String reportId) {
        reportDao.updateReport0(Integer.parseInt(article));
        reportDao.updateById0(Integer.parseInt(reportId));
    }

    /**
     * 驳回
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        reportDao.deleteById(id);
    }


}
