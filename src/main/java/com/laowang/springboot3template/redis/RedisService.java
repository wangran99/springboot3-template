package com.laowang.springboot3template.redis;

import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.TimeUnit;
@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    private void set(String key, Object value, long minutes) {
        redisTemplate.opsForValue().set(key, value, minutes, TimeUnit.MINUTES);
    }
    public Object get(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        this.redisTemplate.delete(key);
    }
}
