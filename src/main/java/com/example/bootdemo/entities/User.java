package com.example.bootdemo.entities;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONField;

public class User {
    private Long id;
    private String userName;
    @JSONField(serializeFeatures = JSONWriter.Feature.WriteNullStringAsEmpty)
    private String password;


    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
