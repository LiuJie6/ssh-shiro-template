package com.template.controller.auth;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:ssh-shiro-template
 * File Name:IdentityController
 * Package Name:com.template.controller.auth
 * Date:2019/2/19
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController("identityController")
@RequestMapping("api/auth")
@CrossOrigin     //用于跨域
@Api(tags = "身份认证", description = "身份认证接口说明")
public class IdentityController {
}
