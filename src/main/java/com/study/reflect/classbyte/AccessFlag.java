package com.study.reflect.classbyte;

import java.util.ArrayList;
import java.util.List;

public class AccessFlag {

    public final static Flag[] CLASS = {
            Flag.create("PUBLIC", "0001"),
            Flag.create("FINAL", "0010"),
            Flag.create("SUPER", "0020"),
            Flag.create("INTERFACE", "0200"),
            Flag.create("ABSTRACT", "0400"),
            Flag.create("SYNTHETIC", "1000"),
            Flag.create("ANNOTATION", "2000"),
            Flag.create("ENUM", "400")
    };

    public static final Flag[] FIELD = {
            Flag.create("PUBLIC", "0001"),
            Flag.create("PRIVATE", "0002"),
            Flag.create("PROTECTED", "0004"),
            Flag.create("STATIC", "0008"),
            Flag.create("FINAL", "0010"),
            Flag.create("VOLATILE", "0040"),
            Flag.create("TRANSIENT", "0080"),
            Flag.create("SYNTHETIC", "1000"),
            Flag.create("ENUM", "4000")
    };

    public static final Flag[] METHOD = {
            Flag.create("PUBLIC", "0001"),
            Flag.create("PRIVATE", "0002"),
            Flag.create("PROTECTED", "0004"),
            Flag.create("STATIC", "0008"),
            Flag.create("FINAL", "0010"),
            Flag.create("SYNCHRONIZED", "0020"),
            Flag.create("BRIDGE", "0040"),
            Flag.create("VARARGS", "0080"),
            Flag.create("NATIVE", "0100"),
            Flag.create("ABSTRACT", "0400"),
            Flag.create("STRICTFP", "0800"),
            Flag.create("SYNTHETIC", "1000")
    };

    public static final Flag[] INNER = {
            Flag.create("ACC_PUBLIC", "0001"),
            Flag.create("ACC_PRIVATE", "0002"),
            Flag.create("ACC_PROTECTED", "0004"),
            Flag.create("ACC_STATIC", "0008"),
            Flag.create("ACC_FINAL", "0010"),
            Flag.create("ACC_INTERFACE", "0020"),
            Flag.create("ACC_ABSTRACT", "0400"),
            Flag.create("ACC_SYNTHETIC", "1000"),
            Flag.create("ACC_ANNOTATION", "2000"),
            Flag.create("ACC_ENUM", "4000")
    };

    public static List<Flag> getFlags(short flag, Flag[] flags){
        List<Flag> _fs = new ArrayList<>();
        for (Flag f : flags) {
            if (f.in(flag)) _fs.add(f);
        }
        return _fs;
    }

    public static class Flag{
        private String name;
        private short flag;

        private Flag(String name, short flag) {
            this.name = name;
            this.flag = flag;
        }

        public static Flag create(String name, String flag){
            return new Flag(name, (short) Integer.parseInt(flag, 16));
        }

        public boolean in(short flag){
            return (this.flag & flag) > 0;
        }

        public String getName() {
            return name;
        }

        public short getFlag() {
            return flag;
        }
    }
}

