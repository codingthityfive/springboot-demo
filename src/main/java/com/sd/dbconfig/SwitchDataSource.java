package com.sd.dbconfig;

import java.lang.annotation.*;
/**
 * @program: springboot-demo
 * @description: 用于指明mybatis Dao层接口使用哪个数据源
 * @author: zZ
 * @create: 2018-07-19 17:22
 **/
@Retention(RetentionPolicy.RUNTIME)//运行时保留
@Target(ElementType.METHOD)//作用范围是方法
public @interface SwitchDataSource {
    /**
     * value　使用的数据源的名称,默认为master
     * @return
     */
    DataSourceType value() default DataSourceType.Master;
}
