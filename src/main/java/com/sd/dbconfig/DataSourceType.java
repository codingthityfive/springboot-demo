package com.sd.dbconfig;

/**
 * @program: springboot-demo
 * @description: 数据源枚举类
 * @author: zZ
 * @create: 2018-07-19 17:21
 **/
public enum DataSourceType {

    // 1主库
    Master("master"),
    // 2从库
    Slave("slave"),
    // 3从库
    Pg("pg");

    private String name;

    private DataSourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
