package com.template.controller.auth;

import com.template.dao.basic.account.api.IAccountDao;
import com.template.model.api.auth.LoginModel.LoginModel;
import com.template.model.basic.account.AccountModel;
import com.template.model.response.ResponseResult;
import com.template.model.state.State;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    private static final Logger logger = LoggerFactory.getLogger(IdentityController.class);

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @PostMapping("login")
    @ApiOperation(value = "账户登录"
            , notes = "账户登录接口说明"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams(@ApiImplicitParam(dataTypeClass = LoginModel.class))
    @ApiResponses({@ApiResponse(response = ResponseResult.class, code = 200, message = "账户登录结果")})
    public Object login(@RequestBody LoginModel params) throws Exception {
        UsernamePasswordToken token = new UsernamePasswordToken(params.getAccountName(), params.getAccountPassword());
        Subject currentUser = SecurityUtils.getSubject();

        ResponseResult responseResult;
        try {
            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                Map<String, Object> data = new HashMap<>();
                data.put("JSESSIONID", currentUser.getSession().getId());
                AccountModel accountModel = new AccountModel();
                accountModel.setAccountName(params.getAccountName());
                accountModel = this.accountDao.queryModel(accountModel);
                if (accountModel != null) {
                    data.put("accountName", accountModel.getAccountName());
                    data.put("accountId", accountModel.getAccountId());
                    responseResult = new ResponseResult(true, State.SUCCESS.getCode(), "", data);
                } else {
                    responseResult = new ResponseResult(false, State.FAILURE.getCode(), "用户名或密码错误");
                }
            } else {
                token.clear();
                responseResult = new ResponseResult(false, State.FAILURE.getCode(), "登录失败");
            }
        } catch (UnknownAccountException uae) {
            logger.info("对用户【" + params.getAccountName() + "】进行登录验证..验证未通过，未知用户");
            responseResult = new ResponseResult(false, State.FAILURE.getCode(), "未知用户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户【" + params.getAccountName() + "】进行登录验证..验证未通过，错误的凭证");
            responseResult = new ResponseResult(false, State.FAILURE.getCode(), "错误的凭证");
        } catch (LockedAccountException lae) {
            logger.info("对用户【" + params.getAccountName() + "】进行登录验证..验证未通过，账号已锁定");
            responseResult = new ResponseResult(false, State.FAILURE.getCode(), "账号已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户【" + params.getAccountName() + "】进行登录验证..验证未通过，错误次数过多");
            responseResult = new ResponseResult(false, State.FAILURE.getCode(), "错误次数过多");
        } catch (AuthenticationException ae) {
            logger.info("对用户【" + params.getAccountName() + "】进行登录验证..验证未通过，验证失败");
            responseResult = new ResponseResult(false, State.FAILURE.getCode(), "验证失败");
        }
        return responseResult;
    }

    @GetMapping("unauthenticated")
    Object unauthenticated(){
        return new ResponseResult(false,State.FAILURE.getCode(),"用户身份信息为认证，请登录后再操作");
    }

    @GetMapping("unauthorized")
    Object unauthorized(){
        return new ResponseResult(false,State.FAILURE.getCode(),"用户操作未授权，禁止访问");
    }
}
