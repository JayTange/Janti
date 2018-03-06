package com.janti.dao;

import com.janti.domain.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodDaoTest {
    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void listGoodsVo(){
        List<GoodsVo> list = goodsDao.listGoodsVo();
        System.out.println(list);
    }
}