package com.template.dao.basic.account.api;

import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;

/**
 * Project Name:ssh-shiro-template
 * File Name:IAccountDao
 * Package Name:com.template.dao.basic.account.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IAccountDao {

    /**
     * 查询特定账户信息
     *
     * @param accountModel 查询条件
     * @return 查询结果
     */
    AccountModel queryModel(AccountModel accountModel);

    /**
     * 查询账户总数
     *
     * @param accountModel 账户查询条件
     * @param roleModel 角色查询条件
     * @return 满足条件的账户总数
     */
    int queryTotalCount(AccountModel accountModel, RoleModel roleModel);
}
