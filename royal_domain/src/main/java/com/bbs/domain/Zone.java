package com.bbs.domain;

import java.util.List;

/*
    交流区实体类:bbs_zone_table
 */
public class Zone {

    private Integer zoneId;//交流区编号
    private String zoneName;//交流区名字
    private Integer isDef;//是否默认，1代表默认，2代表非默认
    private List<Article> articles;//用于封装交流区下所有帖子

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
