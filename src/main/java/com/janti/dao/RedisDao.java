package com.janti.dao;

import com.janti.rediskey.KeyPrefix;
import com.janti.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author tangj
 * @date 2018/3/7 20:45
 */
@Component
public class RedisDao {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 设置对象
     *
     * @param prefix
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = RedisUtil.beanToString(value);
            if (StringUtils.isBlank(str)) {
                return false;
            }
            // 生成真正的key
            String realKey = prefix.getPrefix();
            int seconds = prefix.expireSeconds();
            if (seconds < 1) {
                jedis.set(realKey, str);
            } else {
                jedis.setex(realKey, seconds, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 获取对象
     *
     * @param prefix
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key
            String realKey = prefix.getPrefix();
            String str = jedis.get(realKey);
            T t = RedisUtil.stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
