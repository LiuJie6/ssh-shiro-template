package com.template.model.auth;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-shiro-template
 * File Name:FunctionalityModel
 * Package Name:com.template.model.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "functionality", schema = "ssh-shiro", catalog = "")
public class FunctionalityModel {

    private long functionId;
    private String functionCode;
    private String functionContent;
    private String functionState;
    private String functionRemark;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "function_id")
    public long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(long functionId) {
        this.functionId = functionId;
    }

    @Basic
    @Column(name = "function_code")
    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    @Basic
    @Column(name = "function_content")
    public String getFunctionContent() {
        return functionContent;
    }

    public void setFunctionContent(String functionContent) {
        this.functionContent = functionContent;
    }

    @Basic
    @Column(name = "function_state")
    public String getFunctionState() {
        return functionState;
    }

    public void setFunctionState(String functionState) {
        this.functionState = functionState;
    }

    @Basic
    @Column(name = "function_remark")
    public String getFunctionRemark() {
        return functionRemark;
    }

    public void setFunctionRemark(String functionRemark) {
        this.functionRemark = functionRemark;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionalityModel that = (FunctionalityModel) o;

        if (functionId != that.functionId) return false;
        if (functionCode != null ? !functionCode.equals(that.functionCode) : that.functionCode != null) return false;
        if (functionContent != null ? !functionContent.equals(that.functionContent) : that.functionContent != null)
            return false;
        if (functionState != null ? !functionState.equals(that.functionState) : that.functionState != null)
            return false;
        if (functionRemark != null ? !functionRemark.equals(that.functionRemark) : that.functionRemark != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (functionId ^ (functionId >>> 32));
        result = 31 * result + (functionCode != null ? functionCode.hashCode() : 0);
        result = 31 * result + (functionContent != null ? functionContent.hashCode() : 0);
        result = 31 * result + (functionState != null ? functionState.hashCode() : 0);
        result = 31 * result + (functionRemark != null ? functionRemark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FunctionalityModel{" +
                "functionId=" + functionId +
                ", functionCode='" + functionCode + '\'' +
                ", functionContent='" + functionContent + '\'' +
                ", functionState='" + functionState + '\'' +
                ", functionRemark='" + functionRemark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
