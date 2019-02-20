package com.template.service.basic.account.impl;

import com.template.dao.common.api.ICommonDao;
import com.template.model.api.auth.userinfo.UserInfo;
import com.template.model.api.basic.account.AccountCreateModel;
import com.template.model.auth.AccountRoleModel;
import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;
import com.template.service.auth.role.api.IRoleService;
import com.template.service.basic.account.api.IAccountService;
import com.template.service.userinfo.api.IUserInfoService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountServiceImpl
 * Package Name:com.template.service.basic.account.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    @Resource(name = "userInfoService")
    private IUserInfoService userInfoService;

    @Resource(name = "roleService")
    private IRoleService roleService;

    @Value("${hash.algorithm.name}")
    private String algorithmName;

    @Value("${hash.iterations}")
    private int hashIterations;

    /**
     * 创建账户
     *
     * @param params 账户模型
     * @throws Exception 异常
     */
    @Override
    public void createAccount(AccountCreateModel params) throws Exception {
        //UserInfo userInfo = this.userInfoService.getUserInfo();

        RoleModel roleModel = this.roleService.queryModelByRoleId(params.getAccountRole());

        String saltValue = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new SimpleHash(this.algorithmName
                , params.getAccountPassword()
                , saltValue
                , this.hashIterations).toString();

        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(params.getAccountName());
        accountModel.setAccountPassword(password);
        accountModel.setAccountSaltValue(saltValue);
        accountModel.setEmail(params.getEmail());
        accountModel.setPhone(params.getPhone());
        accountModel.setCreateTime(Timestamp.from(Instant.now()));
        accountModel.setUpdateTime(Timestamp.from(Instant.now()));

        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountModel(accountModel);
        accountRoleModel.setRoleModel(roleModel);
        accountRoleModel.setCreateTime(Timestamp.from(Instant.now()));
        accountRoleModel.setUpdateTime(Timestamp.from(Instant.now()));

        this.commonDao.saveModel(accountRoleModel);
    }
}
