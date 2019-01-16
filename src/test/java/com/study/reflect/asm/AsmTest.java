package com.study.reflect.asm;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.study.reflect.asm.visit.AsmClassInfo;
import com.study.reflect.asm.visit.StudyClassVisitor;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

@JSONType
public class AsmTest {

    @JSONField
    private String msg;

    @Test
    public void testAsmReader()throws Exception{
        AsmClassInfo classInfo = new AsmClassInfo();
        ClassReader reader = new ClassReader(ClassVisitor.class.getResourceAsStream("ClassVisitor.class"));
        StudyClassVisitor visitor = new StudyClassVisitor(classInfo);
        reader.accept(visitor, 0);
    }


}
