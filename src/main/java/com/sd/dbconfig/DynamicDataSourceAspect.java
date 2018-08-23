package com.sd.dbconfig;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.sd.log.LogUtils;

/**
 * @program: springboot-demo
 * @description: 动态切换数据源的切面，根据注解的内容来切换数据源
 * @author: zZ
 * @create: 2018-07-19 17:23
 **/
@Aspect
@Order(1)   //设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中)
@Component
public class DynamicDataSourceAspect {

    /**
     * 在SwitchDataSource注解的方法之前执行
     * @see com.sd.dbconfig.SwitchDataSource
     */
    @Before("@annotation(SwitchDataSource)")
    public void before(JoinPoint joinPoint){
        //获取当前访问的class
        Class<?> aClass = joinPoint.getTarget().getClass();
        //获取方法的签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取访问的方法名字
        String methodName = methodSignature.getName();
        //得到当前方法的参数类型
        Class[] argsClass = methodSignature.getParameterTypes();
        String dataSourceName = DataSourceContextHolder.DEFAULT_DATASOURCE_NAME;
        try {
            Method method = aClass.getMethod(methodName, argsClass);
            //判断是否存在数据源切换注解
            if (method.isAnnotationPresent(SwitchDataSource.class)) {
                SwitchDataSource annotation = method.getAnnotation(SwitchDataSource.class);
                //赋值数据源的名称
                dataSourceName = annotation.value().getName();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //切换数据源
        LogUtils.getPlatformLogger().info("dataSourceName:" + dataSourceName);
        DataSourceContextHolder.setDatasourceName(dataSourceName);
    }

    /**
     * 在SwitchDataSource注解的方法之后执行
     * @see com.sd.dbconfig.SwitchDataSource
     */
    @After("@annotation(SwitchDataSource)")
    public void after(){
        //清除进程中数据源的名字
        DataSourceContextHolder.clearDatasourceName();
    }
}
