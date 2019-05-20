package com.study.springboot;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.Enumeration;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import static org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION;

public class SpringApplicationTest {

    @Test
    public void loader()throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        Enumeration<URL> urls = classLoader.getResources(FACTORIES_RESOURCE_LOCATION);
        while (urls.hasMoreElements()){
            System.out.println(urls.nextElement());
        }
        System.out.println("------------");
        urls = classLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION);
        while (urls.hasMoreElements()){
            System.out.println(urls.nextElement());
        }
    }

    @Test
    public void testWType()throws Exception{
        Class<WebApplicationType> clazz = WebApplicationType.class;
        Method method = clazz.getDeclaredMethod("deduceFromClasspath");
        method.setAccessible(true);
        Object result = method.invoke(null);
        System.out.println(result);


    }

    @Test
    public void conditionEvaluation(){

    }
}
