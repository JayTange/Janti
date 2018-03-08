package com.janti.dao;

import com.janti.domain.SeckillUserVo;
import org.apache.ibatis.annotations.*;

/**
 * @author tangj
 * @date 2018/3/8 21:49
 */
@Mapper
public interface SeckillUserDao {

    @Select("select * from seckill_user where id = #{id}")
    SeckillUserVo getById(@Param("id") long id);

    @Update("update seckil_user set password = #{password} where id = #{id}")
    void update(SeckillUserVo seckillUserVo);

    @Insert("insert into seckill_user(id,password) values(#{id},#{password})")
    int insertSeckillUser(SeckillUserVo seckillUserVo);
}
