package com.janti.dao;

import com.janti.domain.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author tangj
 * @date 2018/3/5 21:38
 */
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    public UserVo getUserById(@Param("id") int id);

    @Insert("insert into user(id,name) values(#{id}, #{name})")
    public int insert(UserVo userVo);
}
