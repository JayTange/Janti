package com.janti.service.impl;

import com.janti.domain.UserVo;
import com.janti.exception.TipException;
import com.janti.service.ISeckillUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tangj
 * @date 2018/3/6 22:52
 */
@Service
public class SeckillUserService implements ISeckillUserService{
    @Override
    public UserVo login(String userId, String password) {
        if (StringUtils.isBlank(userId)|| StringUtils.isBlank(password)){
            throw new TipException("用户名和密码为空");
        }

        return null;
    }
}
