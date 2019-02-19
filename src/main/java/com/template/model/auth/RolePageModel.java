package com.template.model.auth;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-shiro-template
 * File Name:RolePageModel
 * Package Name:com.template.model.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "role_page", schema = "ssh-shiro", catalog = "")
public class RolePageModel {
    private long rolePageId;
    private RoleModel roleModel;
    private PageModel pageModel;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_page_id")
    public long getRolePageId() {
        return rolePageId;
    }

    public void setRolePageId(long rolePageId) {
        this.rolePageId = rolePageId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "page_id")
    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
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

        RolePageModel that = (RolePageModel) o;

        if (rolePageId != that.rolePageId) return false;
        if (roleModel != null ? !roleModel.equals(that.roleModel) : that.roleModel != null) return false;
        if (pageModel != null ? !pageModel.equals(that.pageModel) : that.pageModel != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (rolePageId ^ (rolePageId >>> 32));
        result = 31 * result + (roleModel != null ? roleModel.hashCode() : 0);
        result = 31 * result + (pageModel != null ? pageModel.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePageModel{" +
                "rolePageId=" + rolePageId +
                ", roleModel=" + roleModel +
                ", pageModel=" + pageModel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
