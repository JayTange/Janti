package com.janti.rediskey;

/**
 * @author tangj
 * @date 2018/3/7 20:49
 */
public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}
