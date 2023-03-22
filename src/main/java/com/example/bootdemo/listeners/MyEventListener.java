package com.example.bootdemo.listeners;

import com.example.bootdemo.entities.Student;
import com.example.bootdemo.events.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        Student student = event.getStudent();
        System.out.println("student name: " + student.getName());
        System.out.println("student id: " +student.getId());
    }
}
