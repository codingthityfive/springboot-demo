package com.sd.log;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: springboot-demo
 * @description: 日志枚举类
 * @author: zZ
 * @create: 2018-05-18 15:44
 **/
public enum LogEnum {


    BUSINESS("business"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),;


    @Setter
    @Getter
    private String category;


    LogEnum(String category) {
        this.category = category;
    }

}
