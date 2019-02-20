package com.template.controller.manage.account;

import com.template.model.api.basic.account.AccountCreateModel;
import com.template.model.response.ResponseResult;
import com.template.model.state.State;
import com.template.service.basic.account.api.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project Name:ssh-shiro-template
 * File Name:AccountManageController
 * Package Name:com.template.controller.manage.account
 * Date:2019/2/20
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController("accountManageController")
@RequestMapping("api/manage/account")
@CrossOrigin
@Api(tags = "账户管理", description = "账户管理接口说明", hidden = true)
public class AccountManageController {

    @Resource(name = "accountService")
    private IAccountService accountService;

    @PostMapping("create")
    @ApiOperation(value = "创建账户"
            , notes = "创建账户接口说明"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(response = ResponseResult.class, code = 200, message = "账户创建结果")})
    @RequiresRoles("administrator")
    public Object createAccount(@RequestBody AccountCreateModel params) throws Exception {

        this.accountService.createAccount(params);

        return new ResponseResult(true, State.SUCCESS.getCode(), "");
    }

}
