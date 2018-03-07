package com.janti.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author tangj
 * @date 2018/3/7 22:44
 */
@Configuration
public class RedisConfig {
    @Value("spring.redis.host")
    private String host;
    @Value("spring.redis.port")
    private int port;
    @Value("spring.redis.timeout")
    private int timeout;
    @Value("spring.redis.password")
    private String password;

    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    public JedisPool JedisPoolBean() {
        JedisPoolConfig jedisPoolConfig = getRedisConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }
}
