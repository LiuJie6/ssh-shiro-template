package com.template.service.auth.role.api;

import com.template.model.auth.RoleModel;

/**
 * Project Name:ssh-shiro-template
 * File Name:IRoleService
 * Package Name:com.template.service.auth.role.api
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IRoleService {

    RoleModel queryModelByRoleId(long roleId);

    boolean isExit(long roleId);

    //ResponsePagingDataModel queryRoleList(RoleQueryModel roleQueryModel) throws Exception;
}
