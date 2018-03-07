package com.janti.dao;

import com.janti.rediskey.GoodsKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author tangj
 * @date 2018/3/7 21:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;
    @Test
    public void testGet(){
        redisDao.set(GoodsKey.getGoodsDetail,"aaaaa");
    }

    @Test
    public void testSet(){
        redisDao.get(GoodsKey.getGoodsDetail,String.class);
    }
}