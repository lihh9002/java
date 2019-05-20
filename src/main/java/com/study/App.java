package com.study;

import com.study.context.StudyApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class App {
    public static void main(String... args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        StudyApplicationContext study = context.getBean(StudyApplicationContext.class);
        study.sayName();
    }
}
