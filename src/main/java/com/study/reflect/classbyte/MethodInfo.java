package com.study.reflect.classbyte;

import com.study.reflect.classbyte.attributes.AttributeInfo;
import com.study.reflect.classbyte.constants.ConstantPool;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MethodInfo {
    public ElementAccessFlag accessFlag;
    public Utf8Info name;
    public Utf8Info descriptor;
    public List<AttributeInfo> attributes;

    public static List<MethodInfo> readMethods(ByteBuffer buffer){
        short count = HexByteReadUtil.getCount(buffer);
        List<MethodInfo> methods = new ArrayList<>(count);
        for (short i = 0; i < count; i++) {
            MethodInfo method = new MethodInfo();
            method.accessFlag = ElementAccessFlag.readMethodAccessFlag(buffer);
            method.name = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
            method.descriptor = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
            method.attributes = AttributeInfo.readAttributes(buffer);
            methods.add(method);
        }
        return methods;
    }
}
