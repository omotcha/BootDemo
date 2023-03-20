package com.example.bootdemo.controllers;

import com.example.bootdemo.entities.User;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/json")
@Api(tags = "Json测试")
public class JsonController {
    @GetMapping("/user")
    public User getUser(){
        return new User(0L, "omotcha", "sadf");
    }

    @GetMapping("/list")
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "ua", "ua");
        User user2 = new User(2L, "ub", "ub");
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/map")
    public Map<String, Object> getUserMap(){
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "ua", null);
        map.put("user", user);
        map.put("age", 10);
        map.put("country", "null");
        return map;
    }
}
