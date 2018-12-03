package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class StringInfo extends BaseConstant{
    private short index;

    @Override
    public void read(ByteBuffer buffer) {
        this.index = HexByteReadUtil.getIndex(buffer);
    }

    public short getIndex() {
        return index;
    }

    public Utf8Info getValue() {
        return ConstantPool.getConstant(index);
    }

}
