package com.study.reflect.classbyte.constants;

import java.nio.ByteBuffer;

public abstract class BaseConstant {

    public abstract void read(ByteBuffer buffer);

    protected short idx;

    protected short tag;

    public short getIdx() {
        return idx;
    }

    public short getTag() {
        return tag;
    }
}
