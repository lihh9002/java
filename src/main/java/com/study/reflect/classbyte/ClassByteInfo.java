package com.study.reflect.classbyte;

import com.study.reflect.classbyte.attributes.AttributeInfo;
import com.study.reflect.classbyte.constants.BaseConstant;
import com.study.reflect.classbyte.constants.ClassInfo;
import com.study.reflect.classbyte.constants.ConstantPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassByteInfo {
    public String magic;
    public short minorVersion;
    public short majorVersion;

    public Map<Short, BaseConstant> constantPool;

    public ElementAccessFlag classAccessFlag;

    public ClassInfo clazz;

    public ClassInfo superClass;

    public List<ClassInfo> interfaces;

    public List<FieldInfo> fields;

    public List<MethodInfo> methods;

    public List<AttributeInfo> attributes;

    public static ClassByteInfo readClass(byte[] bytes){
        ClassByteInfo clazz = new ClassByteInfo();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        clazz.magic = readMagic(buffer);
        clazz.minorVersion = HexByteReadUtil.getShort(buffer);
        clazz.majorVersion = HexByteReadUtil.getShort(buffer);
        clazz.constantPool = ConstantPool.readConstantPool(buffer);
        clazz.classAccessFlag = ElementAccessFlag.readClassAccessFlag(buffer);
        clazz.clazz = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
        clazz.superClass = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
        clazz.interfaces = readInterfaces(buffer);
        clazz.fields = FieldInfo.readFields(buffer);
        clazz.methods = MethodInfo.readMethods(buffer);
        clazz.attributes = AttributeInfo.readAttributes(buffer);
        return clazz;
    }

    private static String readMagic(ByteBuffer buffer){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.toHexString(buffer.get() & '\u00ff'));
        }
        return sb.toString();
    }

    private static List<ClassInfo> readInterfaces(ByteBuffer buffer){
        short count = HexByteReadUtil.getCount(buffer);
        List<ClassInfo> interfaces = new ArrayList<>(count);
        for (short i = 0; i < count; i++) {
            interfaces.add(ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer)));
        }
        return interfaces;
    }
}

