package com.example.bootdemo.controllers;

import com.example.bootdemo.entities.JsonResult;
import com.example.bootdemo.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/jsonResult")
@Api(tags = "测试")
public class JsonResultController {
    @GetMapping(value="/user")
    @ApiOperation("获得用户信息")
    public JsonResult<User> getUser(){
        User me = new User(0L, "omotcha", "sadf");
        return new JsonResult<>(me);
    }

    @RequestMapping("/list")
    public JsonResult<List> getUserList(){
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "ua", "ua");
        User user2 = new User(2L, "ub", "ub");
        users.add(user1);
        users.add(user2);
        return new JsonResult<>(users, "list success");
    }

    @RequestMapping("/map")
    public JsonResult<Map> getMap(){
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "ua", null);
        map.put("user", user);
        map.put("age", 10);
        map.put("country", "null");
        return new JsonResult<>(map);
    }
}
