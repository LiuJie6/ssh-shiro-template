package com.template.service.userinfo.api;

import com.template.model.api.auth.userinfo.UserInfo;

/**
 * Project Name:ssh-shiro-template
 * File Name:IUserInfoService
 * Package Name:com.template.service.userinfo.api
 * Date:2019/2/19
 * Author:liujie
 * Description:获取当前登录用户信息
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IUserInfoService {

    /**
     * 获取当前登录的用户信息
     * @return 结果
     * @throws Exception 异常
     */
    UserInfo getUserInfo() throws Exception;

}
