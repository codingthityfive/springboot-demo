package com.sd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sd.log.LogUtils;
import com.sd.model.Account;
import com.sd.service.IAccountService;


/**
 * @program: springboot-demo
 * @description: 用户信息控制器
 * @author: zZ
 * @create: 2018-06-01 15:35
 **/
@Api(value = "用户信息",description = "用户信息",tags = {"用户信息"})
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;


    @ApiOperation(value = "获取mysql库用户信息", notes = "根据url的agentCode来获取用户的详细信息")
    @ApiImplicitParam(name = "agentCode", value = "用户agentCode", required = true,dataType = "String",paramType = "path")
    @GetMapping(value = "/getAccount/{agentCode}")
    public Account getAccount(@PathVariable("agentCode") String agentCode) {

        LogUtils.getPlatformLogger().info("查询mysql库用户信息 agentCode:" + agentCode);
        Account account = accountService.getAccountByMs(agentCode);
        return account;
    }


    @ApiOperation(value = "获取oracle库用户信息", notes = "根据url的agentCode来获取用户的详细信息")
    @ApiImplicitParam(name = "agentCode", value = "用户agentCode", required = true,dataType = "String",paramType = "path")
    @GetMapping(value = "/getAccountDl/{agentCode}")
    public Account getAccountDl(@PathVariable("agentCode") String agentCode) {

        LogUtils.getPlatformLogger().info("查询oracle库用户信息 agentCode:" + agentCode);
        Account account = accountService.getAccountByOc(agentCode);
        return account;
    }

    @ApiOperation(value = "获取postgresql库账号信息", notes = "根据url的agentCode来获取用户的详细信息")
    @ApiImplicitParam(name = "agentCode", value = "用户agentCode", required = true,dataType = "String",paramType = "path")
    @GetMapping(value = "/getAccountPg/{agentCode}")
    public Account getAccountPg(@PathVariable("agentCode") String agentCode) {

        LogUtils.getPlatformLogger().info("查询postgresql库用户信息 agentCode:" + agentCode);
        Account account = accountService.getAccountByPg(agentCode);
        return account;
    }
}
