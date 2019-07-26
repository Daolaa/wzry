package com.bbs.domain;
/*

    新增板块实体类:bbs_zoneapply_table
 */
public class Zoneapply {
    private Integer applyZoneId;//
    private String zoneName;//新增板块名字
    private String userName;//用户名
    private String reason;//申请原因
    private Integer status;//处理状态(未处理-0,已处理-1)

    public Integer getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(Integer applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
