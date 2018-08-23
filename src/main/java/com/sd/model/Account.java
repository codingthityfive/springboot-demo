package com.sd.model;

import java.util.Date;

import lombok.Data;

/**
 * @program: springboot-demo
 * @description: 用户信息
 * @author: zZ
 * @create: 2018-06-01 15:31
 **/
@Data
public class Account {

    private long id;
    private String agentCode;
    private Date createTime;
    private Date operateTime;
}
