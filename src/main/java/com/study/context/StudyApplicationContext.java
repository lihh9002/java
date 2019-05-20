package com.study.context;

import com.study.spring.annotation.TestCondition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Conditional(TestCondition.class)
public class StudyApplicationContext {

    @Resource
    private ApplicationContext applicationContext;

    public void sayName(){
        System.out.println(applicationContext.getApplicationName());
        System.out.println(applicationContext.getId());
    }
}
