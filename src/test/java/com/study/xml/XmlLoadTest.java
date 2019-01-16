package com.study.xml;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

public class XmlLoadTest {

    @Test
    public void loadBean(){
        XStream xStream = new XStream();
        Object obj = xStream.fromXML("<Student>\n" +
                "    <id>1</id>\n" +
                "    <name>Tom</name>\n" +
                "</Student>");
        Student student = (Student) obj;
        System.out.println(student);
        System.out.println(xStream.getClassLoader());
        System.out.println(student.getClass().getClassLoader());
    }
}
