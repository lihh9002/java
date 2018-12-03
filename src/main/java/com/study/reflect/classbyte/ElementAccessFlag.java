package com.study.reflect.classbyte;

import java.nio.ByteBuffer;
import java.util.List;

public class ElementAccessFlag {
    private short flag;

    private List<AccessFlag.Flag> flags;

    public static ElementAccessFlag readClassAccessFlag(ByteBuffer buffer){
        return readAccessFlag(buffer, AccessFlag.CLASS);
    }

    public static ElementAccessFlag readFieldAccessFlag(ByteBuffer buffer){
        return readAccessFlag(buffer, AccessFlag.FIELD);
    }

    public static ElementAccessFlag readMethodAccessFlag(ByteBuffer buffer){
        return readAccessFlag(buffer, AccessFlag.METHOD);
    }

    public static ElementAccessFlag readInnerAccessFlag(ByteBuffer buffer){
        return readAccessFlag(buffer, AccessFlag.INNER);
    }

    private static ElementAccessFlag readAccessFlag(ByteBuffer buffer, AccessFlag.Flag[] flags){
        ElementAccessFlag accessFlag = new ElementAccessFlag();
        accessFlag.flag = HexByteReadUtil.getShort(buffer);
        accessFlag.flags = AccessFlag.getFlags(accessFlag.flag, flags);
        return accessFlag;
    }

    public short getFlag() {
        return flag;
    }

    public List<AccessFlag.Flag> getFlags() {
        return flags;
    }
}
