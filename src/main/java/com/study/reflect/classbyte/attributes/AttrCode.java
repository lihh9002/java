package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;
import com.study.reflect.classbyte.constants.ClassInfo;
import com.study.reflect.classbyte.constants.ConstantPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AttrCode extends AttributeInfo{
    public short maxStack;
    public short maxLocals;
    public int codeLength;
    public String code;
    public List<ExceptionInfo> exceptions;
    public List<AttributeInfo> attributes;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        this.maxStack = HexByteReadUtil.getShort(buffer);
        this.maxLocals = HexByteReadUtil.getShort(buffer);
        this.codeLength = HexByteReadUtil.getInt(buffer);
        this.code = HexByteReadUtil.getString(buffer, this.codeLength);
        this.exceptions = ExceptionInfo.readException(buffer);
        this.attributes = AttributeInfo.readAttributes(buffer);
    }

//    public

    public static class ExceptionInfo{
        public short startPc;
        public short endPc;
        public short handlerPc;
        public ClassInfo catchType;

        public static List<ExceptionInfo> readException(ByteBuffer buffer){
            short count = HexByteReadUtil.getCount(buffer);
            List<ExceptionInfo> exceptions = new ArrayList<>(count);
            for (short i = 0; i < count; i++) {
                ExceptionInfo exception = new ExceptionInfo();
                exception.startPc = HexByteReadUtil.getShort(buffer);
                exception.endPc = HexByteReadUtil.getShort(buffer);
                exception.handlerPc = HexByteReadUtil.getShort(buffer);
                exception.catchType = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
                exceptions.add(exception);
            }
            return exceptions;
        }
    }
}
