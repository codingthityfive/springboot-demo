package com.sd.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sd.exception.MyException;

/**
 * @program: springboot-demo
 * @description: 测试全局异常处理
 * @author: zZ
 * @create: 2018-07-05 13:30
 **/
@Api(value = "异常管理测试",description = "异常信息处理",tags = {"异常管理测试"})
@RestController
public class ExceptionTestController {
    /**
     * 异常错误处理返回错误页面
     */
    @RequestMapping("/returnHtml")
    public String testErrorReturn1() throws Exception{
        throw new Exception("请求出错!");
    }

    /**
     * 异常错误处理返回json格式
     * 根据抛出的异常类型匹配到对应的异常处理方法
     */
    @RequestMapping("/returnJson")
    public String testErrorReturn2() throws MyException {
        throw new MyException("网络问题");
    }


}
