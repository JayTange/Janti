package com.janti.dao;

import com.janti.rediskey.KeyPrefix;
import com.janti.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangj
 * @date 2018/3/7 20:45
 */
@Component
public class RedisDao {

    private static Logger logger = LoggerFactory.getLogger(RedisDao.class);

    @Autowired
    private JedisPool jedisPool;

    /**
     * 向redis存储
     *
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = RedisUtil.beanToString(value);
            if (StringUtils.isBlank(str)) {
                return false;
            }
            // 生成真正的key
            String realKey = prefix.getPrefix() + key;
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
     * 根据key,取出缓存
     *
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 生成真正的key
            String realKey = prefix.getPrefix()+key;
            String str = jedis.get(realKey);
            T t = RedisUtil.stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断key是否存在
     *
     * @param prefix
     * @return
     */
    public boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 获取真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 根据key删除存储
     *
     * @param prefix
     * @param key
     * @return
     */
    public boolean delete(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            long ret = jedis.del(realKey);
            return ret > 0;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 批量删除key
     *
     * @param prefix
     * @return
     */
    public boolean batchDelete(KeyPrefix prefix) {
        if (prefix == null) {
            return false;
        }
        List<String> keys = scanKeys(prefix.getPrefix());
        if (keys == null || keys.size() <= 0) {
            return true;
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(keys.toArray(new String[0]));
            return true;
        } catch (final Exception e) {
            logger.error("redis批量删除出错" + e.getMessage());
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 扫描redis中的key
     *
     * @param key
     * @return
     */
    public List<String> scanKeys(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<String> keys = new ArrayList<String>();
            String cursor = "0";
            ScanParams sp = new ScanParams();
            sp.match("*" + key + "*");
            sp.count(100);
            do {
                ScanResult<String> ret = jedis.scan(cursor, sp);
                List<String> result = ret.getResult();
                if (result != null && result.size() > 0) {
                    keys.addAll(result);
                }
                //再处理cursor
                cursor = ret.getStringCursor();
            } while (!cursor.equals("0"));
            return keys;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 增加value值
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long incrVaule(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 减少value值
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decrValue(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 归还连接到连接池
     *
     * @param jedis
     */
    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
