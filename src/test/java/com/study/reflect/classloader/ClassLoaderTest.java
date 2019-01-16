package com.study.reflect.classloader;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassLoaderTest {

    @Test
    public void testClassLoader()throws Exception{
        String url = "jdbc:mysql://192.168.0.100:3307/jd_minipro?" +
                "useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("select * from tb_article");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("article_title"));
        }
        ps.close();
        connection.close();
    }
}
