package com.sd.redis;

/**
 * @program: springboot-demo
 * @description: redis服务接口
 * @author: zZ
 * @create: 2018-07-05 09:09
 **/
public interface IRedisService {
    /**
     * 设置redis值
     *
     * @param key
     * @param value
     */
    void setValue(String key, Object value);


    /**
     * 设置redis值
     *
     * @param key
     * @param value
     */
    void setValue(String key, Object value, long timeout);

    /**
     * 从redis获取值
     *
     * @param key
     * @return
     */
    Object getValue(String key);
}
