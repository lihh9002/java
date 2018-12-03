package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class FloatInfo extends BaseConstant{
    private float value;

    @Override
    public void read(ByteBuffer buffer) {
        this.value = HexByteReadUtil.getFloat(buffer);
    }

    public float getValue() {
        return value;
    }
}
