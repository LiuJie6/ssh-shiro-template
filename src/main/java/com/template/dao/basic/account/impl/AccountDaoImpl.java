package com.template.dao.basic.account.impl;

import com.template.dao.basic.account.api.IAccountDao;
import com.template.dao.common.api.ICommonDao;
import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountDaoImpl
 * Package Name:com.template.dao.basic.account.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao{
    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询特定账号信息
     *
     * @param accountModel 查询条件
     * @return 查询结果
     */
    @Override
    public AccountModel queryModel(AccountModel accountModel) {
        return this.commonDao.queryModel(this.getCondition(accountModel), AccountModel.class);
    }

    /**
     * 查询账户总数
     *
     * @param accountModel 账户查询条件
     * @param roleModel    角色查询条件
     * @return 满足条件的账户总数
     */
    @Override
    public int queryTotalCount(AccountModel accountModel, RoleModel roleModel) {
        return 0;
    }

    private String getCondition(AccountModel accountModel) {
        HashSet<String> conditions = new HashSet<>();
        long accountId = accountModel.getAccountId();
        String accountName = accountModel.getAccountName();
        String accountPassword = accountModel.getAccountPassword();

        if (accountId > 0)
            conditions.add("model.accountId=" + accountId);
        if (accountName != null && !accountName.isEmpty()) {
            conditions.add("model.accountName='" + accountName + "'");
        }
        if (accountPassword != null && !accountPassword.isEmpty()) {
            conditions.add("model.accountPassword='" + accountPassword + "'");
        }
        return this.commonDao.getAndCondition(conditions);
    }
}
