package com.template.model.auth;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-shiro-template
 * File Name:PageModel
 * Package Name:com.template.model.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "page", schema = "ssh-shiro", catalog = "")
public class PageModel {
    private long pageId;
    private String pagePath;
    private String pageState;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String pageRemark;
    private String pageCode;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "page_id")
    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    @Basic
    @Column(name = "page_path")
    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    @Basic
    @Column(name = "page_state")
    public String getPageState() {
        return pageState;
    }

    public void setPageState(String pageState) {
        this.pageState = pageState;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "page_remark")
    public String getPageRemark() {
        return pageRemark;
    }

    public void setPageRemark(String pageRemark) {
        this.pageRemark = pageRemark;
    }

    @Basic
    @Column(name = "page_code")
    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageModel pageModel = (PageModel) o;

        if (pageId != pageModel.pageId) return false;
        if (pagePath != null ? !pagePath.equals(pageModel.pagePath) : pageModel.pagePath != null) return false;
        if (pageState != null ? !pageState.equals(pageModel.pageState) : pageModel.pageState != null) return false;
        if (createTime != null ? !createTime.equals(pageModel.createTime) : pageModel.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(pageModel.updateTime) : pageModel.updateTime != null) return false;
        if (pageRemark != null ? !pageRemark.equals(pageModel.pageRemark) : pageModel.pageRemark != null) return false;
        return pageCode != null ? pageCode.equals(pageModel.pageCode) : pageModel.pageCode == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (pageId ^ (pageId >>> 32));
        result = 31 * result + (pagePath != null ? pagePath.hashCode() : 0);
        result = 31 * result + (pageState != null ? pageState.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (pageRemark != null ? pageRemark.hashCode() : 0);
        result = 31 * result + (pageCode != null ? pageCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "pageId=" + pageId +
                ", pagePath='" + pagePath + '\'' +
                ", pageState='" + pageState + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", pageRemark='" + pageRemark + '\'' +
                ", pageCode='" + pageCode + '\'' +
                '}';
    }
}
