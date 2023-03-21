package com.example.bootdemo.controllers;

import com.example.bootdemo.entities.Student;
import com.example.bootdemo.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Api(tags="数据库测试")
public class StudentDAOController {

    @Autowired
    private StudentService service;

    @ApiOperation("获得测试用户名字")
    @GetMapping("/getOmotchaName")
    public String getOmotcha(){
        Student omotcha = service.getStudent(1);
        return omotcha.getName();
    }

    @ApiOperation("获得测试用户ID")
    @GetMapping("/getOmotchaID")
    public Integer getOmotchaID(){
        Student omotcha = service.getStudentByName("omotcha");
        return omotcha.getId();
    }
}
