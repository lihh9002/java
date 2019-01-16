package com.study.context;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudyApplicationContext {

    @Resource
    private ApplicationContext applicationContext;

    public void sayName(){
        System.out.println(applicationContext.getApplicationName());
        System.out.println(applicationContext.getId());
    }
}
