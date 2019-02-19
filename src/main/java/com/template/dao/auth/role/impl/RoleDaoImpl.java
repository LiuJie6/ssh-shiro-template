package com.template.dao.auth.role.impl;

import com.template.dao.auth.role.api.IRoleDao;
import com.template.dao.common.api.ICommonDao;
import com.template.model.auth.RoleModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:RoleDaoImpl
 * Package Name:com.template.dao.auth.role.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao{

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 查询特定角色信息
     *
     * @param roleModel 查询条件
     * @return 查询结果
     */
    @Override
    public RoleModel queryModel(RoleModel roleModel) {
        return this.commonDao.queryModel(this.getCondition(roleModel), RoleModel.class);
    }

    /**
     * 查询特定角色信息
     *
     * @param roleModel 查询条件
     * @return 查询结果
     */
    @Override
    public List<RoleModel> queryModels(RoleModel roleModel) {
        return this.commonDao.queryModels(this.getCondition(roleModel), RoleModel.class);
    }

    private String getCondition(RoleModel roleModel) {
        HashSet<String> conditions = new HashSet<>();
        long roleId = roleModel.getRoleId();
        String roleName = roleModel.getRoleName();
        if (roleId > 0)
            conditions.add("model.roleId=" + roleId);
        if (roleName != null && !roleName.isEmpty()) {
            conditions.add("model.roleName='" + roleName + "'");
        }
        return this.commonDao.getAndCondition(conditions);
    }
}
