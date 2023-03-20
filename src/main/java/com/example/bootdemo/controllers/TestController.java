package com.example.bootdemo.controllers;

import com.example.bootdemo.configs.MicroServiceConfigProp;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
@Api(tags = "其他测试")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private MicroServiceConfigProp microServiceConfigProp;

    @GetMapping("/springboot")
    public String testStringBoot(){
        return "test passed";
    }

    @GetMapping("/microserviceconfig")
    public String testMicroServiceConfig(){
        logger.info("order url: {}", microServiceConfigProp.getOrderUrl());
        logger.info("user url: {}", microServiceConfigProp.getUserUrl());
        logger.info("shopping url: {}", microServiceConfigProp.getShoppingUrl());
        return "Success";
    }
}
