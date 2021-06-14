package com.example.sm.dao;

import com.example.sm.model.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface recordsMapper {
    @Insert("insert into records (time,email,name,score) values(#{time},#{email},#{name},#{score})")
    int record(String time, String email, String name, String score);

    @Select("select * from records LIMIT #{num}")
    List<Record> listRecords(int num);
}
