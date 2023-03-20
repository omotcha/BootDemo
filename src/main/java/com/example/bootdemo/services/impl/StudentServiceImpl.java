package com.example.bootdemo.services.impl;

import com.example.bootdemo.dao.StudentMapper;
import com.example.bootdemo.entities.Student;
import com.example.bootdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudent(Integer id) {
        return studentMapper.getStudent(id);
    }
}
