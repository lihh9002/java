package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AttrStackMapTable extends AttributeInfo{
    public List<Long> entries;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        short count = HexByteReadUtil.getCount(buffer);
        entries = new ArrayList<>(count);
        for (short i = 0; i < count; i++) {
            entries.add(HexByteReadUtil.getLong(buffer));
        }
    }
}
