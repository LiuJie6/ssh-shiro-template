package com.template.dao.auth.rolepage.api;

import com.template.model.auth.RoleModel;
import com.template.model.auth.RolePageModel;

import java.util.List;

/**
 * Project Name:ssh-shiro-template
 * File Name:IRolePageDao
 * Package Name:com.template.dao.auth.rolepage.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IRolePageDao {

    /**
     * 查询特定一个角色网页权限
     *
     * @param rolePageModel 查询条件
     * @return 查询结果
     */
    RolePageModel queryModel(RolePageModel rolePageModel);

    /**
     * 查询特定一组网页权限
     *
     * @param rolePageModel 查询条件
     * @return 查询结果
     */
    List<RolePageModel> queryModels(RolePageModel rolePageModel);

    /**
     * 查询特定一组角色网页权限信息
     * @param roleModels 角色列表
     * @return 查询结果
     */
    List<RolePageModel> queryModels(List<RoleModel> roleModels);
}
