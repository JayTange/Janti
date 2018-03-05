package com.janti.dao;

import com.janti.domain.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author tangj
 * @date 2018/3/5 21:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        UserVo userVo = new UserVo();
        userVo.setName("aaa");
        userDao.insert(userVo);
    }

    @Test
    public void testSelectDao(){
        UserVo userVo = userDao.getUserById(3);
        System.out.println(userVo);
    }
}