package com.sd.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sd.log.LogUtils;
import com.sd.redis.IRedisService;

/**
 * @program: springboot-demo
 * @description: redis测试
 * @author: zZ
 * @create: 2018-07-10 09:22
 **/
@Api(value = "Redis测试",description = "Redis相关操作",tags = {"Redis测试"})
@RestController
public class RedisTestController {

    @Autowired
    private IRedisService redisService;


    @GetMapping("/redis")
    public String redis(){
        //字符串
        redisService.setValue("redisKey", "redisValue");

        LogUtils.getPlatformLogger().info(redisService.getValue("redisKey"));

        return "redis";
    }
}
