package com.study.reflect.asm.visit;

import org.objectweb.asm.*;

public class StudyFieldVisitor extends FieldVisitor {
    public StudyFieldVisitor() {
        super(Opcodes.ASM5);
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
    public void visitAttribute(Attribute attr) {
        System.out.println("===========visitAttribute end===========");
        System.out.println(attr.type);
        System.out.println(attr.isCodeAttribute());
        System.out.println(attr.isUnknown());
        System.out.println("===========visitAttribute end===========");
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        System.out.println("===========visitAnnotation end===========");
        System.out.println(desc);
        System.out.println(visible);
        System.out.println("===========visitAnnotation end===========");
        return new StudyAnnotationVisitor();
    }
}
