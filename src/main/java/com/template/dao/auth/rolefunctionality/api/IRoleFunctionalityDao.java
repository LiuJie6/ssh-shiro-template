package com.template.dao.auth.rolefunctionality.api;

import com.template.model.auth.RoleFunctionalityModel;
import com.template.model.auth.RoleModel;

import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:IRoleFunctionalityDao
 * Package Name:com.template.dao.auth.rolefunctionality.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IRoleFunctionalityDao {
    /**
     * 查询一个特定角色功能权限信息
     *
     * @param roleFunctionalityModel 查询条件
     * @return 查询结果
     */
    RoleFunctionalityModel queryModel(RoleFunctionalityModel roleFunctionalityModel);

    /**
     * 查询特定一组角色功能权限信息
     *
     * @param roleFunctionalityModel 查询条件
     * @return 查询结果
     */
    List<RoleFunctionalityModel> queryModels(RoleFunctionalityModel roleFunctionalityModel);

    /**
     * 查询特定一组角色功能权限信息
     *
     * @param roleModels 角色列表
     * @return 查询结果
     */
    List<RoleFunctionalityModel> queryModels(List<RoleModel> roleModels);
}
