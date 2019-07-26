package com.czxy.dao;

import com.czxy.domain.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/20
 */
@org.apache.ibatis.annotations.Mapper
public interface PersonMapper extends Mapper<Person> {
    @Select("select * from person where phone = #{phone}")
    Person findPhone (@Param("phone") String phone);

    @Select("SELECT * FROM person WHERE username LIKE #{username} OR address LIKE #{address}")
    List<Person> findByNameAndAddress (@Param("username")String username, @Param("address") String address);
}
