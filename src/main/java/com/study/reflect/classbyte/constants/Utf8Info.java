package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;

public class Utf8Info extends BaseConstant{
    private short length;
    private String value;

    @Override
    public void read(ByteBuffer buffer) {
        this.length = HexByteReadUtil.getLength(buffer);
        this.value = HexByteReadUtil.getString(buffer, this.length);
    }

    public short getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }
}
