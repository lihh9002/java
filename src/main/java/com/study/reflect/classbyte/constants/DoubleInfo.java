package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class DoubleInfo extends BaseConstant{
    private double value;

    @Override
    public void read(ByteBuffer buffer) {
        this.value = HexByteReadUtil.getDouble(buffer);
    }

    public double getValue() {
        return value;
    }
}
