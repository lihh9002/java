package com.study.reflect.classbyte;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.ByteBuffer;

public class ClassByteTest {

    @Test
    public void readClass() throws Exception {
        byte[] bytes = FileUtils.readFileToByteArray(
                new File("C:\\study\\workspace\\java\\target" +
                "\\test-classes\\com\\study\\reflect\\classbyte\\" +
                "ClassByte.class"));
        ClassByteInfo clazz = ClassByteInfo.readClass(bytes);
        System.out.println(clazz.fields.size());
    }
}
