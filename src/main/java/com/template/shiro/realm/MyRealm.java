package com.template.shiro.realm;


import com.template.dao.auth.accountrole.api.IAccountRoleDao;
import com.template.dao.auth.rolefunctionality.api.IRoleFunctionalityDao;
import com.template.dao.basic.account.api.IAccountDao;
import com.template.model.auth.AccountRoleModel;
import com.template.model.auth.FunctionalityModel;
import com.template.model.auth.RoleFunctionalityModel;
import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project Name:electronic-invoice
 * File Name:MyRealm
 * Package Name:com.yk.invoice.shiro.realm
 * Date:2018/12/17
 * Author:zhangju
 * Description:
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Component("MyRealm")
public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @Resource(name = "accountRoleDao")
    private IAccountRoleDao accountRoleDao;

    @Resource(name = "roleFunctionalityDao")
    private IRoleFunctionalityDao roleFunctionalityDao;

    @Resource(name = "hashedCredentialsMatcher")
    private HashedCredentialsMatcher hashedCredentialsMatcher;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("开始授权");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String accountName = (String) principalCollection.getPrimaryPrincipal();
        if (accountName == null) {
            logger.info("授权失败");
            logger.info("结束授权");
            throw new AuthorizationException();
        }
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(accountName);
        accountModel = this.accountDao.queryModel(accountModel);

        if (accountModel == null) {
            logger.info("授权失败");
            logger.info("结束授权");
            throw new AuthorizationException();
        }

        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountModel(accountModel);
        List<AccountRoleModel> accountRoleModels = this.accountRoleDao.queryModels(accountRoleModel);

        List<RoleFunctionalityModel> roleFunctionalityModels = this.roleFunctionalityDao.queryModels(accountRoleModels
                .stream()
                .map(AccountRoleModel::getRoleModel)
                .collect(Collectors.toList()));

        authorizationInfo.setRoles(accountRoleModels
                .stream()
                .map(AccountRoleModel::getRoleModel)
                .map(RoleModel::getRoleName)
                .collect(Collectors.toSet()));

        authorizationInfo.setStringPermissions(roleFunctionalityModels
                .stream()
                .map(RoleFunctionalityModel::getFunctionalityModel)
                .map(FunctionalityModel::getFunctionContent)
                .collect(Collectors.toSet()));

        logger.info("结束授权");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("开始认证");
        String accountName = (String) authenticationToken.getPrincipal();

        if (accountName == null) {
            logger.info("认证失败");
            logger.info("结束认证");
            throw new AuthenticationException();
        }
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(accountName);
        accountModel = this.accountDao.queryModel(accountModel);

        if (accountModel == null) {
            logger.info("认证失败");
            logger.info("结束认证");
            throw new AuthenticationException();
        }
        logger.info("方法：" + this.hashedCredentialsMatcher.getHashAlgorithmName());
        logger.info("次数：" + this.hashedCredentialsMatcher.getHashIterations());
        this.setCredentialsMatcher(this.hashedCredentialsMatcher);
        logger.info("结束认证");
        return new SimpleAuthenticationInfo(accountModel.getAccountName()
                , accountModel.getAccountPassword()
                , ByteSource.Util.bytes(accountModel.getAccountSaltValue())
                , getName());

    }

}
