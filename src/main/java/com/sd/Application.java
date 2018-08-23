package com.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @program: springboot-demo
 * @description: Spring Boot程序入口
 * @author: zZ
 * @create: 2018-05-18 12:58
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//exclude 排除自动读取数据源 需要添加两个数据库
@EnableTransactionManagement(order = 2)//设置事务执行顺序(需要在切换数据源之后 否则只走默认库)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
