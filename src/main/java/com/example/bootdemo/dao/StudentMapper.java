package com.example.bootdemo.dao;

import com.example.bootdemo.entities.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student getStudent(@Param("id") Integer id); // based on mapper + xml

    @Select("select * from STUDENT ST WHERE ST.Name = #{name}")
    Student getStudentByName(@Param("name") String name); // based on mapper + annotation
}
