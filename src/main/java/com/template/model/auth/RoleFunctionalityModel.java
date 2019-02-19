package com.template.model.auth;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-shiro-template
 * File Name:RoleFunctionalityModel
 * Package Name:com.template.model.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "role_functionality", schema = "ssh-shiro", catalog = "")
public class RoleFunctionalityModel {
    private long roleFunctionalityId;
    private RoleModel roleModel;
    private FunctionalityModel functionalityModel;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_functionality_id")
    public long getRoleFunctionalityId() {
        return roleFunctionalityId;
    }

    public void setRoleFunctionalityId(long roleFunctionalityId) {
        this.roleFunctionalityId = roleFunctionalityId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id",foreignKey = @ForeignKey(name = "fk_role_functionality_role_id"))
    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    @ManyToOne
    @JoinColumn(name = "function_id", referencedColumnName = "function_id",foreignKey = @ForeignKey(name = "fk_role_functionality_function_id"))
    public FunctionalityModel getFunctionalityModel() {
        return functionalityModel;
    }

    public void setFunctionalityModel(FunctionalityModel functionalityModel) {
        this.functionalityModel = functionalityModel;
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

        RoleFunctionalityModel that = (RoleFunctionalityModel) o;

        if (roleFunctionalityId != that.roleFunctionalityId) return false;
        if (roleModel != null ? !roleModel.equals(that.roleModel) : that.roleModel != null) return false;
        if (functionalityModel != null ? !functionalityModel.equals(that.functionalityModel) : that.functionalityModel != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (roleFunctionalityId ^ (roleFunctionalityId >>> 32));
        result = 31 * result + (roleModel != null ? roleModel.hashCode() : 0);
        result = 31 * result + (functionalityModel != null ? functionalityModel.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoleFunctionalityModel{" +
                "roleFunctionalityId=" + roleFunctionalityId +
                ", roleModel=" + roleModel +
                ", functionalityModel=" + functionalityModel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
