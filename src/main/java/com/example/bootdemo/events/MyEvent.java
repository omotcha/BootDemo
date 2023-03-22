package com.example.bootdemo.events;

import com.example.bootdemo.entities.Student;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private Student student;

    public MyEvent(Object source, Student student){
        super(source);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
