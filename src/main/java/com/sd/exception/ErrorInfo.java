package com.sd.exception;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description: 错误返回的json封装对象
 *
 * @author: zZ
 * @create: 2018-07-05 13:29
 **/
@Data
public class ErrorInfo<T> {

    private Integer code;       //消息类型
    private String message;     //消息内容
    private String url;         //请求路径
    private T data;             //返回数据

}
