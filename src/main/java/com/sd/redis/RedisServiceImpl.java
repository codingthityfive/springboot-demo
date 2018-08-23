package com.sd.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

/**
 * @program: springboot-demo
 * @description: redis实现类
 * @author: zZ
 * @create: 2018-07-05 09:10
 **/
@Service("redisService")
public class RedisServiceImpl implements IRedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    @Override
    public void setValue(String key, Object value, long timeout) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public Object getValue(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
}
