package com.study.kefu.v1.support;

import com.study.kefu.v1.entity.message.Message;
import sun.java2d.cmm.ProfileDeferralInfo;

import java.lang.reflect.ParameterizedType;

public interface GenericMethodMatcher<T> {

    /**
     * 获取实现类的泛型类型
     * @return
     */
    default Class<T> getGenericType(){
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * 是否类型匹配
     * @param arg
     * @return
     */
    default boolean typeMatch(T arg){
        return arg.getClass().equals(getGenericType());
    }

    default boolean typeMatch(Class<T> clazz){
        return clazz.equals(getGenericType());
    }
}
