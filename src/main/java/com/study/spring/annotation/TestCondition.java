package com.study.spring.annotation;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TestCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        System.out.println(JSONObject.toJSONString(context.getEnvironment(), true));
        return true;
    }
}
