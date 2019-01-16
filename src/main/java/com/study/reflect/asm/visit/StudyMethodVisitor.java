package com.study.reflect.asm.visit;

import org.objectweb.asm.*;

import java.util.Arrays;

public class StudyMethodVisitor extends MethodVisitor {
    public AsmMethodInfo method;

    public StudyMethodVisitor() {
        super(Opcodes.ASM5);
    }

    public StudyMethodVisitor(AsmMethodInfo method) {
        this();
        this.method = method;
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        AsmAttribute attr = new AsmAttribute();
        attr.type = attribute.type;
        method.attributes.add(attr);
    }

    @Override
    public void visitParameter(String name, int access) {
        MethodParameter param = new MethodParameter();
        param.name = name;
        param.access = access;
        method.params.add(param);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
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
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor,
                                                 boolean visible) {
        System.out.println("===========visitTypeAnnotation===========");
        System.out.println(typeRef);
        System.out.println(typePath);
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitTypeAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
        System.out.println("===========visitAnnotableParameterCount===========");
        System.out.println(parameterCount);
        System.out.println(visible);
        System.out.println("===========visitAnnotableParameterCount end===========");
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String descriptor, boolean visible) {
        System.out.println("===========visitParameterAnnotation===========");
        System.out.println(parameter);
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitParameterAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        System.out.println("===========visitFrame===========");
        System.out.println(type);
        System.out.println(numLocal);
        System.out.println(Arrays.toString(local));
        System.out.println(numStack);
        System.out.println(Arrays.toString(stack));
        System.out.println("===========visitFrame end===========");
    }

    @Override
    public void visitInsn(int opcode) {
        System.out.println("===========visitInsn===========");
        System.out.println(opcode);
        System.out.println("===========visitInsn end===========");
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        System.out.println("===========visitIntInsn===========");
        System.out.println(opcode);
        System.out.println(operand);
        System.out.println("===========visitIntInsn end===========");
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        System.out.println("===========visitVarInsn===========");
        System.out.println(opcode);
        System.out.println(var);
        System.out.println("===========visitVarInsn end===========");
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        System.out.println("===========visitTypeInsn===========");
        System.out.println(opcode);
        System.out.println(type);
        System.out.println("===========visitTypeInsn end===========");
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        System.out.println("===========visitFieldInsn===========");
        System.out.println(opcode);
        System.out.println(owner);
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println("===========visitFieldInsn end===========");
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        System.out.println("===========visitMethodInsn===========");
        System.out.println(opcode);
        System.out.println(owner);
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println(isInterface);
        System.out.println("===========visitMethodInsn end===========");
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        System.out.println("===========visitInvokeDynamicInsn===========");
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println(bootstrapMethodHandle);
        System.out.println(Arrays.toString(bootstrapMethodArguments));
        System.out.println("===========visitInvokeDynamicInsn end===========");
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        System.out.println("===========visitJumpInsn===========");
        System.out.println(opcode);
        System.out.println(label);
        System.out.println("===========visitJumpInsn end===========");
    }

    @Override
    public void visitLabel(Label label) {
        System.out.println("===========visitLabel===========");
        System.out.println(label);
        System.out.println("===========visitLabel end===========");
    }

    @Override
    public void visitLdcInsn(Object value) {
        System.out.println("===========visitLdcInsn===========");
        System.out.println(value);
        System.out.println("===========visitLdcInsn end===========");
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        System.out.println("===========visitIincInsn===========");
        System.out.println(var);
        System.out.println(increment);
        System.out.println("===========visitIincInsn end===========");
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        System.out.println("===========visitTableSwitchInsn===========");
        System.out.println(min);
        System.out.println(max);
        System.out.println(dflt);
        System.out.println(labels);
        System.out.println("===========visitTableSwitchInsn end===========");
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        System.out.println("===========visitTableSwitchInsn===========");
        System.out.println(dflt);
        System.out.println(Arrays.toString(keys));
        System.out.println(labels);
        System.out.println("===========visitTableSwitchInsn end===========");
    }

    @Override
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        System.out.println("===========visitMultiANewArrayInsn===========");
        System.out.println(descriptor);
        System.out.println(numDimensions);
        System.out.println("===========visitMultiANewArrayInsn end===========");
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor,
                                                 boolean visible) {
        System.out.println("===========visitInsnAnnotation===========");
        System.out.println(typeRef);
        System.out.println(typePath);
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitInsnAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        System.out.println("===========visitInsnAnnotation===========");
        System.out.println(start);
        System.out.println(end);
        System.out.println(handler);
        System.out.println(type);
        System.out.println("===========visitInsnAnnotation end===========");
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath,
                                                     String descriptor, boolean visible) {
        System.out.println("===========visitTryCatchAnnotation===========");
        System.out.println(typeRef);
        System.out.println(typePath);
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitTryCatchAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitLocalVariable(String name, String descriptor, String signature,
                                   Label start, Label end, int index) {
        System.out.println("===========visitLocalVariable===========");
        System.out.println(name);
        System.out.println(descriptor);
        System.out.println(signature);
        System.out.println(start);
        System.out.println(end);
        System.out.println(index);
        System.out.println("===========visitLocalVariable end===========");
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start,
                                                          Label[] end, int[] index, String descriptor,
                                                          boolean visible) {
        System.out.println("===========visitLocalVariableAnnotation===========");
        System.out.println(typeRef);
        System.out.println(typePath);
        System.out.println(start);
        System.out.println(end);
        System.out.println(Arrays.toString(index));
        System.out.println(descriptor);
        System.out.println(visible);
        System.out.println("===========visitLocalVariableAnnotation end===========");
        return new StudyAnnotationVisitor();
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        System.out.println("===========visitLineNumber===========");
        System.out.println(line);
        System.out.println(start);
        System.out.println("===========visitLineNumber end===========");
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        System.out.println("===========visitMaxs===========");
        System.out.println(maxStack);
        System.out.println(maxLocals);
        System.out.println("===========visitMaxs end===========");
    }
}
