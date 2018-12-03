package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class AttrLineNumber extends AttributeInfo{
    public Map<Short, Short> lines;
    public short count;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        count = HexByteReadUtil.getCount(buffer);
        lines = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            lines.put(HexByteReadUtil.getShort(buffer), HexByteReadUtil.getShort(buffer));
        }
    }
}
