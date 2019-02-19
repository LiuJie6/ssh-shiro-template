package com.template.service.userinfo.impl;

import com.template.dao.auth.accountrole.api.IAccountRoleDao;
import com.template.dao.basic.account.api.IAccountDao;
import com.template.model.api.auth.userinfo.UserInfo;
import com.template.service.userinfo.api.IUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project Name:ssh-shiro-template
 * File Name:UserInfoServiceImpl
 * Package Name:com.template.service.userinfo.impl
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @Resource(name = "accountRoleDao")
    private IAccountRoleDao accountRoleDao;

    /**
     * 获取当前登录的用户信息
     *
     * @return 结果
     * @throws Exception 异常
     */
    @Override
    public UserInfo getUserInfo() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser == null){
            throw new Exception("当前用户不存在");
        }
        String sessionId = currentUser.getSession().getId().toString();
        if(sessionId == null){
            throw new Exception("sessionId不存在");
        }

        return null;
    }
}
