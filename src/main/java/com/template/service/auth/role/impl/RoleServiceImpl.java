package com.template.service.auth.role.impl;

import com.template.dao.auth.role.api.IRoleDao;
import com.template.model.auth.RoleModel;
import com.template.service.auth.role.api.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project Name:ssh-shiro-template
 * File Name:RoleServiceImpl
 * Package Name:com.template.service.auth.role.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource(name = "roleDao")
    private IRoleDao roleDao;

    @Override
    public RoleModel queryModelByRoleId(long roleId) {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId(roleId);
        return this.roleDao.queryModel(roleModel);
    }

    @Override
    public boolean isExit(long roleId) {

        RoleModel roleModel = this.queryModelByRoleId(roleId);
        return roleModel != null;

    }
}
