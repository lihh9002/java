package com.study.reflect.asm.visit;

import org.objectweb.asm.*;

import java.util.Arrays;

public class StudyClassVisitor extends ClassVisitor {
    public AsmClassInfo classInfo;

    public StudyClassVisitor() {
        super(Opcodes.ASM5);
    }

    public StudyClassVisitor(AsmClassInfo classInfo){
        super(Opcodes.ASM5);
        this.classInfo = classInfo;
    }

    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        classInfo.version = version;
        classInfo.access = access;
        classInfo.name = name;
        classInfo.signature = signature;
        classInfo.superName = superName;
        classInfo.interfaces = interfaces;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println("===========visitField===========");
        System.out.println(access);
        System.out.println(name);
        System.out.println(desc);
        System.out.println(signature);
        System.out.println(value);
        System.out.println("===========visitField end===========");
        return new StudyFieldVisitor();
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {
        System.out.println("===========visitModule===========");
        System.out.println(name);
        System.out.println(access);
        System.out.println(version);
        System.out.println("===========visitModule end===========");
        return new StudyModuleVisitor();
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.println("===========visitTypeAnnotation===========");
        System.out.println(typeRef);
        System.out.println(typePath);
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitTypeAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("===========visitAnnotation===========");
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        AsmAttribute attr = new AsmAttribute();
        attr.type = attribute.type;
        classInfo.attributes.add(attr);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("===========visitTypeAnnotation===========");
        System.out.println(access);
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println(signature);
        System.out.println(Arrays.toString(exceptions));
        System.out.println("===========visitTypeAnnotation end===========");
        return new StudyMethodVisitor();
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        InnerClass inner = new InnerClass();
        inner.name = name;
        inner.outerName = outerName;
        inner.innerName = innerName;
        inner.access = access;
        classInfo.inners.add(inner);
    }

    /**
     * jdk 11
     * @param nestHost
     */
    @Override
    public void visitNestHost(String nestHost) {
        System.out.println("===========visitNestHost===========");
        System.out.println(nestHost);
        System.out.println("===========visitNestHost end===========");
    }

    /**
     * jdk 11
     * @param nestMember
     */
    @Override
    public void visitNestMember(String nestMember) {
        System.out.println("===========visitNestMember===========");
        System.out.println(nestMember);
        System.out.println("===========visitNestMember end===========");
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
        OuterClass outer = new OuterClass();
        outer.owner = owner;
        outer.name = name;
        outer.descriptor = descriptor;
        classInfo.outer = outer;
    }

    @Override
    public void visitSource(String source, String debug) {
        classInfo.source = source;
        classInfo.debug = debug;
    }
}
