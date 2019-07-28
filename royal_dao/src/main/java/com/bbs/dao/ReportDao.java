package com.bbs.dao;

import com.bbs.domain.Article;
import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    /**
     * 查询所有举报贴
     * @return
     */
    @Select("select * from bbs_report_table")
    public List<Report> findAll();

    /**
     * 查询相关帖子
     * @return
     */
    @Select("select * from bbs_article_table where articleId=#{id}")
    public Article findById(Integer id);

    /**
     * 更改屏蔽状态
     */
    @Update("update bbs_article_table set isReport=1 where articleId=#{id}")
    public void updateReport1(Integer id);

    /**
     *
     * 解除屏蔽状态
     */
    @Update("update bbs_article_table set isReport=0 where articleId=#{id}")
    public void updateReport0(Integer id);

    /**
     * 未处理状态
     * @param
     */
    @Update("update bbs_report_table set reportStatus=0 where reportId=#{ids}")
    public void updateById0(Integer ids);

    /**
     * 已处理状态
     * @param
     */
    @Update("update bbs_report_table set reportStatus=1 where reportId=#{ids}")
    public void updateById1(Integer ids);

    /**
     * 驳回
     * @param id
     */
    @Delete("delete from bbs_report_table where reportId = #{id}")
    public void deleteById(Integer id);
}
