package com.template.model.api.basic.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountCreateModel
 * Package Name:com.template.model.api.basic.account
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@ApiModel(description = "账户创建数据模型")
public class AccountCreateModel {

    @ApiModelProperty(dataType = "string", name = "accountName", required = true, value = "账户名称", example = "admin")
    private String accountName;

    @ApiModelProperty(dataType = "string", name = "accountPassword", required = true, value = "账户密码", example = "yk@1234")
    private String accountPassword;

    @ApiModelProperty(dataType = "long", name = "accountRole", required = true, value = "账户角色", example = "1")
    private long accountRole;

    @ApiModelProperty(dataType = "string", name = "phone", value = "手机号码", example = "12300000001")
    private String phone;

    @ApiModelProperty(dataType = "string", name = "email", required = true, value = "邮件地址", example = "admin@yun-kai.com")
    private String email;

    @ApiModelProperty(dataType = "boolean", name = "smsNotice", required = true, value = "是否短信接收通知", example = "false")
    private boolean smsNotice;

    @ApiModelProperty(dataType = "boolean", name = "mailNotice", required = true, value = "是否邮件接收通知", example = "false")
    private boolean mailNotice;


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

    public long getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(long accountRole) {
        this.accountRole = accountRole;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSmsNotice() {
        return smsNotice;
    }

    public void setSmsNotice(boolean smsNotice) {
        this.smsNotice = smsNotice;
    }

    public boolean isMailNotice() {
        return mailNotice;
    }

    public void setMailNotice(boolean mailNotice) {
        this.mailNotice = mailNotice;
    }

}
