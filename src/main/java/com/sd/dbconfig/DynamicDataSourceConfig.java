package com.sd.dbconfig;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.sd.log.LogUtils;

/**
 * @program: springboot-demo
 * @description: 动态数据源配置类
 * @author: zZ
 * @create: 2018-07-19 17:22
 **/
@Configuration
public class DynamicDataSourceConfig {

    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        LogUtils.getPlatformLogger().info("master");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        LogUtils.getPlatformLogger().info("slave");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pg")
    @ConfigurationProperties(prefix = "spring.datasource.pg")
    public DataSource pgDataSource() {
        LogUtils.getPlatformLogger().info("pg");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary //优先使用,多数据源
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        DataSource master = masterDataSource();
        DataSource slave = slaveDataSource();
        DataSource pg = pgDataSource();

        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(master);
        //配置多数据源
        Map<Object, Object> dataSourceMap = new HashMap<>();
        //填入主数据源
        dataSourceMap.put(DataSourceType.Master.getName(), master);
        //如果从数据源存在，填入从数据源
        if (slave != null) {
            dataSourceMap.put(DataSourceType.Slave.getName(), slave);
        }

        if(pg != null){
            dataSourceMap.put(DataSourceType.Pg.getName(), pg);
        }

        dynamicDataSource.setTargetDataSources(dataSourceMap);

        LogUtils.getPlatformLogger().info("选择数据源:" + dataSourceMap.toString());


        return dynamicDataSource;
    }

}
