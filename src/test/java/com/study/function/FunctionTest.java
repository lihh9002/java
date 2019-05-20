package com.study.function;

import org.junit.Test;

import java.util.function.Function;

public class FunctionTest {

    @Test
    public void testFunction(){
        UserInfo userInfo = parse(UserInfo::parseJson, "{}");
        System.out.println(userInfo);
    }

    public <T> T parse(Function<String, T> function, String notify){
        return function.apply(notify);
    }
}

class UserInfo {
    public static UserInfo parseJson(String json){
        return new UserInfo();
    }
}
