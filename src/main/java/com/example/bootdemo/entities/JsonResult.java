package com.example.bootdemo.entities;

public class JsonResult<T> {
    private T data;
    private String code;
    private String msg;
    public JsonResult(){
        this.code = "0";
        this.msg = "success";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "success";
    }


    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
        this.code = "0";
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
