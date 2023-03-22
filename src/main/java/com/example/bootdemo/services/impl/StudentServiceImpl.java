package com.example.bootdemo.services.impl;

import com.example.bootdemo.dao.StudentMapper;
import com.example.bootdemo.entities.Student;
import com.example.bootdemo.events.MyEvent;
import com.example.bootdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public Student getStudent(Integer id) {
        //publish an event
        Student student = studentMapper.getStudent(id);
        MyEvent event = new MyEvent(this, student);
        applicationContext.publishEvent(event);
        return student;
    }

    @Override
    public Student getStudentByName(String name) {
        return studentMapper.getStudentByName(name);
    }
}
