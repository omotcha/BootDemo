package com.example.bootdemo.controllers;

import com.example.bootdemo.Entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/user")
    public User getUser(){
        return new User(0L, "omotcha", "sadf");
    }

    @RequestMapping("/list")
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "ua", "ua");
        User user2 = new User(2L, "ub", "ub");
        users.add(user1);
        users.add(user2);
        return users;
    }

    @RequestMapping("/map")
    public Map<String, Object> getUserMap(){
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "ua", "ua");
        map.put("user", user);
        map.put("age", 10);
        map.put("country", null);
        return map;
    }
}
