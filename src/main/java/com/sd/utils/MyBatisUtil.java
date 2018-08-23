package com.sd.utils;

import java.lang.reflect.Field;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sd.model.Account;

/**
 * @program: springboot-demo
 * @description: mybatis工具类
 * @author: zZ
 * @create: 2018-07-06 10:13
 **/
public class MyBatisUtil {

    /**
     * 1.用于获取结果集的映射关系
     */
    public static String getResults(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toUpperCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }

    /**
     * 2.打印结果集的映射关系. 例如：
     *
     * })
     */
    public static void main(String[] args) {
        System.out.println(getResults(Account.class));
    }
}
