package com.template.service.basic.account.api;

import com.template.model.api.basic.account.AccountCreateModel;

/**
 * Project Name:ssh-shiro-template
 * File Name:IAccountService
 * Package Name:com.template.service.basic.account.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IAccountService {

    /**
     * 创建账户
     * @param params 账户模型
     * @throws Exception 异常
     */
    void createAccount(AccountCreateModel params) throws Exception;
}
