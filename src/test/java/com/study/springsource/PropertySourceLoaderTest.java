package com.study.springsource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.client.RestTemplate;

public class PropertySourceLoaderTest {

    @Test
    public void testLoad()throws Exception{

        String path = "test.properties";
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        String name = "applicationConfig: [classpath:/" + path + "]";
        String group = "applicationConfig: [profile=dev]";
    }

    @Test
    public void ebao(){
//        RestTemplate template = new RestTemplate();
//        for (int i = 1660000; i < 1661701; i++) {
//
//            HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.add("Content-Type", "application/json");
//            String requestBody = "{\"quotationId\": " + i + "}";
//            HttpEntity requestEntity = new HttpEntity(requestBody, requestHeaders);
//
//            String response = template.postForObject(
//                    "https://clpcp-uat.ebaocloud.com.cn/ls/services/dt/planService/getPlanInfo",
//                    requestEntity, String.class);
//            JSONObject json = JSON.parseObject(response);
//            if (json.getInteger("status") == 0){
//                System.out.println(json);
//            }
//        }
    }
}
