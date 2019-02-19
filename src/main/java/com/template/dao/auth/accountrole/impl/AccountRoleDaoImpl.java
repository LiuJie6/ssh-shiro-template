package com.template.dao.auth.accountrole.impl;

import com.template.dao.auth.accountrole.api.IAccountRoleDao;
import com.template.dao.common.api.ICommonDao;
import com.template.model.auth.AccountRoleModel;
import com.template.model.auth.RoleModel;
import com.template.model.basic.account.AccountModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountRoleDaoImpl
 * Package Name:com.template.dao.auth.accountrole.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("accountRoleDao")
public class AccountRoleDaoImpl implements IAccountRoleDao{
    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询特定一个账号角色信息
     *
     * @param accountRoleModel 查询条件
     * @return 查询结果
     */
    @Override
    public AccountRoleModel queryModel(AccountRoleModel accountRoleModel) {
        return this.commonDao.queryModel(this.getCondition(accountRoleModel), AccountRoleModel.class);
    }

    /**
     * 查询特定一组账号角色信息
     *
     * @param accountRoleModel 查询条件
     * @return 查询结果
     */
    @Override
    public List<AccountRoleModel> queryModels(AccountRoleModel accountRoleModel) {
        return this.commonDao.queryModels(this.getCondition(accountRoleModel), AccountRoleModel.class);
    }

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
    @Override
    public List<AccountRoleModel> queryModels(AccountModel accountModel
            , RoleModel roleModel
            , int pageIndex
            , int pageSize
            , boolean desc) {


        String hql = "from AccountRoleModel as model where " + this.getCondition(accountModel, roleModel, desc);

        return this.commonDao.queryModels((pageIndex - 1) * pageSize, pageSize, hql, AccountRoleModel.class);
    }

    /**
     * 查询总数
     *
     * @param accountModel 账户查询条件
     * @param roleModel    角色查询条件
     * @return 满足条件的数量
     */
    @Override
    public long queryCount(AccountModel accountModel, RoleModel roleModel) {
        String hql = this.getCondition(accountModel, roleModel, true);
        return this.commonDao.queryTotalCount(hql, AccountRoleModel.class);
    }

    private String getCondition(AccountModel accountModel, RoleModel roleModel, boolean desc) {
        HashSet<String> conditions = new HashSet<>();

        if (accountModel != null && accountModel.getAccountName() != null && !accountModel.getAccountName().isEmpty()) {
            conditions.add("model.accountModel.accountName like '%" + accountModel.getAccountName() + "%'");
        }
        if (roleModel != null && roleModel.getRoleId() > 0) {
            conditions.add("model.roleModel.roleId =" + roleModel.getRoleId());
        }
        if(accountModel != null && accountModel.getAccountId() > 0){
            conditions.add("model.accountModel.accountId=" + accountModel.getAccountId());
        }


        return this.commonDao.getAndCondition(conditions);
    }


    private String getCondition(AccountRoleModel accountRoleModel) {
        HashSet<String> conditions = new HashSet<>();
        long accountRoleId = accountRoleModel.getAccountRoleId();
        AccountModel accountModel = accountRoleModel.getAccountModel();
        RoleModel roleModel = accountRoleModel.getRoleModel();
        if (accountRoleId > 0) {
            conditions.add("model.accountRoleId=" + accountRoleId);
        }
        if (accountModel != null && accountModel.getAccountId() > 0) {
            conditions.add("model.accountModel.accountId=" + accountModel.getAccountId());
        }
        if (roleModel != null) {
            conditions.add("model.role.roleId=" + roleModel.getRoleId());
        }

        return this.commonDao.getAndCondition(conditions);
    }
}
