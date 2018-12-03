package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class NameAndTypeInfo extends BaseConstant{

    private short index1;

    private short index2;

    @Override
    public void read(ByteBuffer buffer) {
        this.index1 = HexByteReadUtil.getIndex(buffer);
        this.index2 = HexByteReadUtil.getIndex(buffer);
    }

    public short getIndex1() {
        return index1;
    }

    public short getIndex2() {
        return index2;
    }

    public BaseConstant getConstant1(){
        return ConstantPool.getConstant(index1);
    }

    public BaseConstant getConstant2(){
        return ConstantPool.getConstant(index2);
    }
}
