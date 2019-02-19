package com.template.dao.auth.accountrole.api;

import com.template.model.auth.AccountRoleModel;
import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;

import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:IAccountRoleDao
 * Package Name:com.template.dao.auth.accountrole.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IAccountRoleDao {

    /**
     * 查询特定一个账号角色信息
     *
     * @param accountRoleModel 查询条件
     * @return 查询结果
     */
    AccountRoleModel queryModel(AccountRoleModel accountRoleModel);

    /**
     * 查询特定一组账号角色信息
     *
     * @param accountRoleModel 查询条件
     * @return 查询结果
     */
    List<AccountRoleModel> queryModels(AccountRoleModel accountRoleModel);

    /**
     * 分页查询账户列表
     *
     * @param accountModel 账户查询条件
     * @param roleModel    角色查询模型
     * @param pageIndex    分页页码
     * @param pageSize     分页大小
     * @param desc         按照修改时间是否逆序
     * @return 账户角色列表
     */
    List<AccountRoleModel> queryModels(AccountModel accountModel, RoleModel roleModel, int pageIndex, int pageSize, boolean desc);

    /**
     * 查询总数
     *
     * @param accountModel 账户查询条件
     * @param roleModel 角色查询条件
     * @return 满足条件的数量
     */
    long queryCount(AccountModel accountModel, RoleModel roleModel);
}
