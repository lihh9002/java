package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;
import com.study.reflect.classbyte.constants.ConstantPool;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class AttributeInfo {
    public Utf8Info index;
    public int length;

    public abstract void readAttribute(ByteBuffer buffer);

    public static List<AttributeInfo> readAttributes(ByteBuffer buffer){
        short count = HexByteReadUtil.getCount(buffer);
        List<AttributeInfo> attributes = new ArrayList<>(count);
        for (short i = 0; i < count; i++) {
            Utf8Info index = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
            int length = HexByteReadUtil.getInt(buffer);
            AttributeInfo attribute;
            if (index.getValue().equals("SourceFile")){
                attribute = new AttrSourceFile();
            }else if (index.getValue().equals("Code")){
                attribute = new AttrCode();
            }
            else if (index.getValue().equals("LineNumberTable")){
                attribute = new AttrLineNumber();
            }
            else if (index.getValue().equals("LocalVariableTable")){
                attribute = new AttrLocalVariable();
            }
            else if (index.getValue().equals("StackMapTable")){
                attribute = new AttrStackMapTable();
            }
            else{
                attribute = new DefaultAttributeInfo();
            }
            attribute.index = index;
            attribute.length = length;
            attribute.readAttribute(buffer);
            attributes.add(attribute);
        }
        return attributes;
    }
}
