package com.template.model.auth;

import com.template.model.basic.account.AccountModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountRoleModel
 * Package Name:com.template.model.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Entity
@Table(name = "account_role", schema = "ssh-shiro", catalog = "")
public class AccountRoleModel {

    private long accountRoleId;
    private AccountModel accountModel;
    private RoleModel roleModel;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_role_id")
    public long getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(long accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", foreignKey = @ForeignKey(name = "fk_account_role_account_id"))
    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", foreignKey = @ForeignKey(name = "fk_account_role_role_id"))
    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
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

        AccountRoleModel that = (AccountRoleModel) o;

        if (accountRoleId != that.accountRoleId) return false;
        if (accountModel != null ? !accountModel.equals(that.accountModel) : that.accountModel != null) return false;
        if (roleModel != null ? !roleModel.equals(that.roleModel) : that.roleModel != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (accountRoleId ^ (accountRoleId >>> 32));
        result = 31 * result + (accountModel != null ? accountModel.hashCode() : 0);
        result = 31 * result + (roleModel != null ? roleModel.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountRoleModel{" +
                "accountRoleId=" + accountRoleId +
                ", accountModel=" + accountModel +
                ", roleModel=" + roleModel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
