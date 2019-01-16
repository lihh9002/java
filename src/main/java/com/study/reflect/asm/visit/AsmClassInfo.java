package com.study.reflect.asm.visit;

import java.util.LinkedList;
import java.util.List;

public class AsmClassInfo {
    public int version;
    public int access;
    public String name;
    public String signature;
    public String superName;
    public String[] interfaces;

    public String source;
    public String debug;

    public OuterClass outer;

    public List<InnerClass> inners = new LinkedList<>();
    public List<AsmAttribute> attributes = new LinkedList<>();

    public List<AsmMethodInfo> methods = new LinkedList<>();
}

class OuterClass{
    public String owner;
    public String name;
    public String descriptor;
}

class InnerClass{
    public String name;
    public String outerName;
    public String innerName;
    public int access;
}

class AsmAttribute{
    public String type;
}

class AsmMethodInfo{
    public List<MethodParameter> params = new LinkedList<>();
    public List<AsmAttribute> attributes = new LinkedList<>();
}

class MethodParameter{
    public String name;
    public int access;
}

class AsmAnnotation{
    public String name;
    public String value;
}