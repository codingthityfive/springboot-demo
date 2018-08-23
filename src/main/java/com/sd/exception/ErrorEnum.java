package com.sd.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: springboot-demo
 * @description: 错误内容对照
 * @author: zZ
 * @create: 2018-07-05 15:37
 **/
public enum ErrorEnum {

    SUCCESS(1000, "成功"),
    ERROR(1001, "失败"),
    NETWORK_ERROR(1002, "网络问题"),
    ACCOUNT_ERROR(1003, "账号不存在"),
    OTHER_ERROR(1004, "未知错误");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private  String message;

    ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Integer getResponseCode(String msg) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (msg.equals(errorEnum.getMessage())) {
                return errorEnum.getCode();
            }
        }
        return OTHER_ERROR.getCode();
    }

    public static String getResponseMsg(Integer code) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (code.equals(errorEnum.getCode())) {
                return errorEnum.getMessage();
            }
        }
        return OTHER_ERROR.getMessage();
    }

}
