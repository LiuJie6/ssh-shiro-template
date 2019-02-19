package com.template.dao.auth.role.api;

import com.template.model.auth.RoleModel;

import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:IRoleDao
 * Package Name:com.template.dao.auth.role.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IRoleDao {

    /**
     * 查询特定角色信息
     *
     * @param roleModel 查询条件
     * @return 查询结果
     */
    RoleModel queryModel(RoleModel roleModel);
    /**
     * 查询特定角色信息
     *
     * @param roleModel 查询条件
     * @return 查询结果
     */
    List<RoleModel> queryModels(RoleModel roleModel);
}
