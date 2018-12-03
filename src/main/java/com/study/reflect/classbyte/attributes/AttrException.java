package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.constants.ClassInfo;

import java.nio.ByteBuffer;
import java.util.List;

public class AttrException extends AttributeInfo{
    public List<ClassInfo> exceptions;

    @Override
    public void readAttribute(ByteBuffer buffer) {
    }
}
