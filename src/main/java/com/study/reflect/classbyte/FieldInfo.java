package com.study.reflect.classbyte;

import com.study.reflect.classbyte.attributes.AttributeInfo;
import com.study.reflect.classbyte.constants.ConstantPool;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class FieldInfo{

    public ElementAccessFlag accessFlag;
    public Utf8Info name;
    public Utf8Info descriptor;
    public List<AttributeInfo> attributes;

    public static List<FieldInfo> readFields(ByteBuffer buffer){
        short count = HexByteReadUtil.getCount(buffer);
        List<FieldInfo> fields = new ArrayList<>(count);
        for (short i = 0; i < count; i++) {
            FieldInfo field = new FieldInfo();
            field.accessFlag = ElementAccessFlag.readFieldAccessFlag(buffer);
            field.name = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
            field.descriptor = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
            field.attributes = AttributeInfo.readAttributes(buffer);
            fields.add(field);
        }
        return fields;
    }
}
