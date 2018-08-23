package com.sd.exception;

/**
 * @program: springboot-demo
 * @description: 业务层异常
 * @author: zZ
 * @create: 2018-07-06 09:49
 **/
public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
