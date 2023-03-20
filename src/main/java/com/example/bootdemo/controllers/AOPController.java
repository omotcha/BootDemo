package com.example.bootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AOPController {
    @GetMapping("/{name}")
    public String testAOP(@PathVariable String name){
        return "hello" + name;
    }
}
