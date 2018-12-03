package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class IntegerInfo extends BaseConstant{
    private int value;

    @Override
    public void read(ByteBuffer buffer) {
        this.value = HexByteReadUtil.getInt(buffer);
    }

    public int getValue() {
        return value;
    }
}
