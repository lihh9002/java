package com.study.reflect.asm.visit;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

public class StudyAnnotationVisitor extends AnnotationVisitor {
    public StudyAnnotationVisitor() {
        super(Opcodes.ASM5);
    }

    @Override
    public void visit(String name, Object value) {
        System.out.println("===========annotation visit===========");
        System.out.println(name);
        System.out.println(value);
        System.out.println("===========annotation visit end===========");
    }

    @Override
    public void visitEnum(String name, String descriptor, String value) {
        System.out.println("===========visitEnum===========");
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println(value);
        System.out.println("===========visitEnum end===========");
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String descriptor) {
        System.out.println("===========visitAnnotation===========");
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println("===========visitAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        System.out.println("===========visitArray===========");
        System.out.println(name);
        System.out.println("===========visitArray end===========");
        return new StudyAnnotationVisitor();
    }
}
