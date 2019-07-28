package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.util.Date;
import java.util.List;

/*
    帖子实体类:bbs_article_table
 */
public class Article {
    private Integer articleId; //帖子编号
    private String title;//标题
    private String content;//内容
    private Date sendTime;//发送时间
    private String sendTimeStr;
    private String senderName;//发送人姓名
    private Integer isTop;//是否置顶，如果是0，代表不置顶；如果是1，代表置顶；
    private Integer replyCount;//评论数
    private Integer upvoteCount;//点赞数
    private Integer browseCount;//浏览数
    private Integer zoneId;//所在交流区
    private Integer isReport;//屏蔽状态 0是没有屏蔽 1是有屏蔽
    private List<Comment> comments;//用于封装帖子下的所有评论

    public String getSendTimeStr() {
        if(sendTime!=null){
            sendTimeStr = DateUtils.date2String(sendTime, "yyyy-MM-dd HH:mm:ss");
        }
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

   /* public String getSendTimeStr() {
        if (sendTime!=null){
            sendTimeStr= DateUtils.date2String(sendTime,"yyyy-MM-dd HH:mm");
        }
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }*/

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zoneId=" + zoneId +
                ", isReport=" + isReport +
                ", comments=" + comments +
                '}';
    }
}
