package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.constants.BaseConstant;
import com.study.reflect.classbyte.constants.MethodHandleInfo;

import java.nio.ByteBuffer;
import java.util.List;

public class AttrBootstrapMethod extends AttributeInfo{

    public List<BootstrapMethod> methods;

    @Override
    public void readAttribute(ByteBuffer buffer) {
    }

    public static class BootstrapMethod{
        public MethodHandleInfo methodHandle;
        public List<BaseConstant> args;
    }
}
