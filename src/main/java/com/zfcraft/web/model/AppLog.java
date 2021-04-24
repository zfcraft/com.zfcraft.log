package com.zfcraft.web.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class AppLog {
    /**
     * 主键id
     */

    private Integer id;

    /**
     * queryString
     */
    private String queryString;

    /**
     * 推送参数
     */

    private String pushParam;

    /**
     * 推送状态1-成功 0-失败
     */

    private Integer pushState;

    /**
     * 创建时间
     */

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getPushParam() {
        return pushParam;
    }

    public void setPushParam(String pushParam) {
        this.pushParam = pushParam;
    }

    public Integer getPushState() {
        return pushState;
    }

    public void setPushState(Integer pushState) {
        this.pushState = pushState;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
