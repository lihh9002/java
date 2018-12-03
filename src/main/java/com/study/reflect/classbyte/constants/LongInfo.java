package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class LongInfo extends BaseConstant{

    private long value;

    @Override
    public void read(ByteBuffer buffer) {
        this.value = HexByteReadUtil.getLong(buffer);
    }

    public long getValue() {
        return value;
    }
}
