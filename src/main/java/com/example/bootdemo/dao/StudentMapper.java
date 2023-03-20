package com.example.bootdemo.dao;

import com.example.bootdemo.entities.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student getStudent(@Param("id") Integer id);
}
