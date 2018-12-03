package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class MethodHandleInfo extends BaseConstant{

    private byte kind;
    private short index;


    @Override
    public void read(ByteBuffer buffer) {
        this.kind = HexByteReadUtil.getByte(buffer);
        this.index = HexByteReadUtil.getIndex(buffer);
    }

    public byte getKind() {
        return kind;
    }

    public short getIndex() {
        return index;
    }

    public BaseConstant getValue() {
        return ConstantPool.getConstant(index);
    }

}
