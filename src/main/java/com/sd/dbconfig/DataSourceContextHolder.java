package com.sd.dbconfig;

import com.sd.log.LogUtils;

/**
 * @program: springboot-demo
 * @description: 多数据源动态切换的工具类
 * @author: zZ
 * @create: 2018-07-19 17:20
 **/
public class DataSourceContextHolder {
    /**
     * 进程内数据存储
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 默认的数据源的名称
     */
    public static final String DEFAULT_DATASOURCE_NAME = "master";

    /**
     * 设置数据源名
     * @param datasourceName 数据源的名字
     */
    public static void setDatasourceName(String datasourceName){
        LogUtils.getPlatformLogger().info("切换到{}数据源", datasourceName);
        contextHolder.set(datasourceName);
    }

    /**
     * 获取数据源名
     * @return
     */
    public static String getDatasourceName(){
        return contextHolder.get();
    }

    /**
     * 清除数据源名称
     */
    public static void clearDatasourceName(){
        contextHolder.remove();
    }

}
