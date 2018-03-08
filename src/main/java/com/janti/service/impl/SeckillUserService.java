package com.janti.service.impl;

import com.janti.dao.RedisDao;
import com.janti.dao.SeckillUserDao;
import com.janti.domain.SeckillUserVo;
import com.janti.domain.UserVo;
import com.janti.exception.TipException;
import com.janti.rediskey.SeckillUserKey;
import com.janti.service.ISeckillUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangj
 * @date 2018/3/6 22:52
 */
@Service
public class SeckillUserService implements ISeckillUserService {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillUserDao seckillUserDao;

    @Override
    public UserVo login(String userId, String password) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(password)) {
            throw new TipException("用户名或密码为空");
        }

        return null;
    }

    /**
     * 根据ID获取用户，并存入缓存
     *
     * @param id
     * @param password
     * @return
     */
    public SeckillUserVo getById(long id, String password) {
        // 取缓存
        SeckillUserVo user = redisDao.get(SeckillUserKey.getById, "" + id, SeckillUserVo.class);
        if (user != null) {
            return user;
        }
        //如果缓存没有，则从数据库中取
        user = seckillUserDao.getById(id);
        // 如果数据中没有，则新建一个秒杀用户
        if (user == null) {
            user.setId(id);
            user.setPassword(password);
            seckillUserDao.insertSeckillUser(user);
        }
        redisDao.set(SeckillUserKey.getById, "" + id, user);
        return user;
    }
}
