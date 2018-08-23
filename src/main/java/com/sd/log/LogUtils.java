package com.sd.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @program: springboot-demo
 * @description: 日志工具类
 * @author: zZ
 * @create: 2018-05-18 15:44
 **/
public class LogUtils {


    public static Logger getBusinessLogger() {
        return LogManager.getLogger(LogEnum.BUSINESS.getCategory());
    }


    public static Logger getPlatformLogger() {
        return LogManager.getLogger(LogEnum.PLATFORM.getCategory());
    }


    public static Logger getDBLogger() {
        return LogManager.getLogger(LogEnum.DB.getCategory());
    }


    public static Logger getExceptionLogger() {
        return LogManager.getLogger(LogEnum.EXCEPTION.getCategory());
    }


}
