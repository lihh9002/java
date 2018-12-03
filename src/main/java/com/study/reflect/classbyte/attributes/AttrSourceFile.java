package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;
import com.study.reflect.classbyte.constants.ConstantPool;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;

public class AttrSourceFile extends AttributeInfo{

    public Utf8Info sourceFile;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        this.sourceFile = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
    }
}
