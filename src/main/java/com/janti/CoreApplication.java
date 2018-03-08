package com.janti;

import com.janti.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 启动类
 *
 * @author janti
 * @date 2018/3/4 20:54
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class CoreApplication {

    @Autowired
    private RedisConfig redisConfig;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CoreApplication.class);
        application.run(args);
    }

    /**
     * Jedis连接池配置
     *
     * @return
     */
    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMaxWaitMillis(redisConfig.getMaxWait());
        poolConfig.setMinIdle(redisConfig.getMinIdle());
        poolConfig.setMaxIdle(redisConfig.getMaxTotal());
        return poolConfig;
    }

    /**
     * Jedis配置
     *
     * @return
     */
    @Bean
    public JedisPool JedisPoolBean() {
        JedisPoolConfig jedisPoolConfig = getRedisConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout());
        return jedisPool;
    }
}
