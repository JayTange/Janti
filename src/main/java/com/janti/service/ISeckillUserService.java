package com.janti.service;

import com.janti.domain.UserVo;

/**
 * @author tangj
 * @date 2018/3/6 22:29
 */
public interface ISeckillUserService {

    UserVo login(String userId,String password);
}
