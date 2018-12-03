package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class ClassInfo extends BaseConstant{
    private short index;

    @Override
    public void read(ByteBuffer buffer) {
        this.index = HexByteReadUtil.getIndex(buffer);
    }

    public BaseConstant getValue() {
        return ConstantPool.getConstant(this.index);
    }

    public short getIndex() {
        return index;
    }
}
