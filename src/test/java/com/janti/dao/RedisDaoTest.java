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
    public void testSet(){
        redisDao.set(GoodsKey.getGoodsDetail,"1",1);
    }

    @Test
    public void testGet(){
       Integer result =  redisDao.get(GoodsKey.getGoodsDetail,"1",Integer.class);
        System.out.println("取出的结果为： "+result);
    }

    @Test
    public void testExists(){
        boolean result = redisDao.exists(GoodsKey.getGoodsDetail,"1");
        System.out.println("是否存在："+result);
    }

    @Test
    public void testDelete(){
        redisDao.delete(GoodsKey.getGoodsDetail,"1");
        boolean result = redisDao.exists(GoodsKey.getGoodsDetail,"1");
        System.out.println("是否存在："+result);
    }

    @Test
    public void testInsr(){
        Long result = redisDao.incrVaule(GoodsKey.getGoodsDetail,"1");
        System.out.println("增加后的值： "+result);
    }

    @Test
    public void testDesr(){
        Long result = redisDao.decrValue(GoodsKey.getGoodsDetail,"1");
        System.out.println("减少后的值： "+result);
    }
}