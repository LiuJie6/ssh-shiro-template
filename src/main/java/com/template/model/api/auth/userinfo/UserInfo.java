package com.template.model.api.auth.userinfo;

import com.template.model.auth.RoleModel;

/**
 * Project Name:ssh-shiro-template
 * File Name:UserInfo
 * Package Name:com.template.model.api.auth.userinfo
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class UserInfo {

    private long accountId;
    private String accountName;
    private long mainBodyId;
    private String sessionId;
    private RoleModel roleModel;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getMainBodyId() {
        return mainBodyId;
    }

    public void setMainBodyId(long mainBodyId) {
        this.mainBodyId = mainBodyId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }
}
