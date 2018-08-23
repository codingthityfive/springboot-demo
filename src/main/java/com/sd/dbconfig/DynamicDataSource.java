package com.sd.dbconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import com.sd.log.LogUtils;

/**
 * @program: springboot-demo
 * @description: 动态数据源类继承自AbstractRoutingDataSource
 * @author: zZ
 * @create: 2018-07-19 17:21
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    public Object determineCurrentLookupKey() {
        LogUtils.getPlatformLogger().info("数据源{}", DataSourceContextHolder.getDatasourceName());
        return DataSourceContextHolder.getDatasourceName();
    }
}
