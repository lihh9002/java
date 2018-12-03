package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.ElementAccessFlag;
import com.study.reflect.classbyte.constants.ClassInfo;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;
import java.util.List;

public class AttrInnerClass extends AttributeInfo{

    public List<InnerClass> innerClasses;

    @Override
    public void readAttribute(ByteBuffer buffer) {
    }

    public static class InnerClass{
        public ClassInfo inner;
        public ClassInfo outer;
        public Utf8Info name;
        public ElementAccessFlag accessFlag;
    }
}
