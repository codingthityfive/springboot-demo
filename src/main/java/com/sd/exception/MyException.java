package com.sd.exception;

/**
 * @program: springboot-demo
 * @description: 自定义异常
 * @author: zZ
 * @create: 2018-07-05 13:27
 **/
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
