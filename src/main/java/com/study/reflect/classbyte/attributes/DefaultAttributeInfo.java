package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class DefaultAttributeInfo extends AttributeInfo{

    public byte[] info;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        this.info = HexByteReadUtil.getBytes(buffer, length);
    }
}
