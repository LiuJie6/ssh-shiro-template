package com.template.model.api.auth.LoginModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ssh-shiro-template
 * File Name:LoginModel
 * Package Name:com.template.model.api.auth.LoginModel
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@ApiModel(description = "登录数据模型")
public class LoginModel {
    @ApiModelProperty(dataType = "string", name = "accountName", required = true, value = "账户名称")
    private String accountName;
    @ApiModelProperty(dataType = "string", name = "accountPassword", required = true, value = "账户密码")
    private String accountPassword;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

}
