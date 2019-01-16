package com.study.springsource;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;

public class BeanFactoryUtilTest {

    @Test
    public void test(){
        String name = "abc";
        System.out.println(BeanFactoryUtils.transformedBeanName(name));
        name = "&abc";
        System.out.println(BeanFactoryUtils.transformedBeanName(name));
        name = "&&abc";
        System.out.println(BeanFactoryUtils.transformedBeanName(name));
        name = "xyz&&abc";
        System.out.println(BeanFactoryUtils.transformedBeanName(name));
    }
}
