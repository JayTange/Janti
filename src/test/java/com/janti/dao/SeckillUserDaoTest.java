package com.janti.dao;

import com.janti.domain.SeckillUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author tangj
 * @date 2018/3/8 23:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillUserDaoTest {

    @Autowired
    private SeckillUserDao dao;

    @Test
    public void getById() throws Exception {
        SeckillUserVo seckillUserDao =  dao.getById(123456789L);
        System.out.println(seckillUserDao);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void insertSeckillUser() throws Exception {
        SeckillUserVo seckillUserVo = new SeckillUserVo();
        seckillUserVo.setId(89L);
        seckillUserVo.setPassword("afdaf");
        dao.insertSeckillUser(seckillUserVo);
    }

}