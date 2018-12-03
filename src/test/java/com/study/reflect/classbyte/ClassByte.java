package com.study.reflect.classbyte;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public final class ClassByte implements Serializable {
    public final static long n  = 987123412341L;
    public final static double d2  = Math.PI;

    private String field;

    @JSONField
    private Integer num;

    private double d;


    public ClassByte() {
    }

    public ClassByte(int a) {
    }

    public ClassByte(String field) {
        this.field = field;
    }

    public String method(String arg){
        String name = arg + "abc";
        try {
            System.out.println("try");
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
        return name;
    }

    public static String staticMethod(Integer i){
        System.out.println(new Date());

        return String.valueOf(i);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void hello(String s) {
        System.out.println(s);
    }
}
