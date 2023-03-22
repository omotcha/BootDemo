package com.example.bootdemo.listeners;

import com.example.bootdemo.entities.Student;
import com.example.bootdemo.services.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        StudentServiceImpl studentService = applicationContext.getBean(StudentServiceImpl.class);
        Student omotcha = studentService.getStudentByName("omotcha");
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        servletContext.setAttribute("student", omotcha);
    }
}
