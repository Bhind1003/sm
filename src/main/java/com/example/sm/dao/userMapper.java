package com.example.sm.dao;

import com.example.sm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
    @Select("select * from user where email = #{email} LIMIT 1")
    User FindUser(String email);

    @Select("select name from user where email = #{email} LIMIT 1")
    String FindUserName(String email);

    @Insert("insert into user (email,name,password) values(#{email},#{name},#{password})")
    int Register(String email, String name, String password);
}
