package com.study.reflect.classbyte;

import java.nio.ByteBuffer;

public class HexByteReadUtil {

    //u1
    public static byte getByte(ByteBuffer buffer){
        return (byte) (buffer.get() & '\u00ff');
    }

    //u2
    public static short getShort(ByteBuffer buffer){
        return (short) (buffer.getShort() & '\uffff');
    }

    //u4
    public static int getInt(ByteBuffer buffer){
        return buffer.getInt();
    }

    //u8
    public static long getLong(ByteBuffer buffer){
        return buffer.getLong();
    }

    //u4
    public static float getFloat(ByteBuffer buffer){
        return buffer.getFloat();
    }

    //u8
    public static double getDouble(ByteBuffer buffer){
        return buffer.getDouble();
    }

    //u1 * length
    public static String getString(ByteBuffer buffer, int length){
        return new String(getBytes(buffer, length));
    }

    public static byte[] getBytes(ByteBuffer buffer, int length){
        byte[] bytes = new byte[length];
        buffer.get(bytes);
        return bytes;
    }

    //u2
    public static short getLength(ByteBuffer buffer){
        return getShort(buffer);
    }

    //u2
    public static short getIndex(ByteBuffer buffer){
        return getShort(buffer);
    }

    //u1
    public static byte getTag(ByteBuffer buffer){
        return getByte(buffer);
    }

    //u2
    public static short getCount(ByteBuffer buffer){
        return getShort(buffer);
    }
}
