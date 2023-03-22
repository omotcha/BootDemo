package com.example.bootdemo.controllers;

import com.example.bootdemo.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/listener")
public class ListenController {
    @GetMapping("/getOmotcha")
    public Student getOmotcha(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        System.err.println(context.getAttribute("student"));
        return (Student) context.getAttribute("student");
    }
    @GetMapping("/getCurrentUser")
    public Integer getCurrentUser(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try{
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), StandardCharsets.UTF_8));
            cookie.setPath("/");
            cookie.setMaxAge(48*60*60);
            response.addCookie(cookie);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Integer guestCount = (Integer) request.getSession().getServletContext().getAttribute("guestCount:");
//        System.out.println("current guest count: " + guestCount);
        return guestCount;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request){
        System.out.println("initialized name: "+request.getAttribute("name"));
        return "success";
    }

}
