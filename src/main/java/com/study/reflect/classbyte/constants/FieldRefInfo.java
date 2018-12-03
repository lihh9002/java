package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class FieldRefInfo extends BaseConstant{
    private short classIndex;
    private short nameAndTypeIndex;

    @Override
    public void read(ByteBuffer buffer) {
        this.classIndex = HexByteReadUtil.getIndex(buffer);
        this.nameAndTypeIndex = HexByteReadUtil.getIndex(buffer);
    }

    public ClassInfo getClassInfo() {
        return ConstantPool.getConstant(this.classIndex);
    }

    public NameAndTypeInfo getNameAndTypeInfo() {
        return ConstantPool.getConstant(this.nameAndTypeIndex);
    }

    public short getClassIndex() {
        return classIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
