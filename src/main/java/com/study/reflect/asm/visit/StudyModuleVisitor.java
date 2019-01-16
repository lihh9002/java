package com.study.reflect.asm.visit;

import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;

public class StudyModuleVisitor extends ModuleVisitor {
    public StudyModuleVisitor() {
        super(Opcodes.ASM5);
    }

    @Override
    public void visitMainClass(String mainClass) {
        System.out.println("===========visitMainClass===========");
        System.out.println(mainClass);
        System.out.println("===========visitMainClass end===========");
    }

    @Override
    public void visitPackage(String packaze) {
        System.out.println("===========visitPackage===========");
        System.out.println(packaze);
        System.out.println("===========visitPackage end===========");
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        System.out.println("===========visitPackage===========");
        System.out.println(module);
        System.out.println(access);
        System.out.println(version);
        System.out.println("===========visitPackage end===========");
    }

    @Override
    public void visitExport(String packaze, int access, String... modules) {
        System.out.println("===========visitPackage===========");
        System.out.println(packaze);
        System.out.println(access);
        System.out.println(Arrays.toString(modules));
        System.out.println("===========visitPackage end===========");
    }

    @Override
    public void visitOpen(String packaze, int access, String... modules) {
        System.out.println("===========visitPackage===========");
        System.out.println(packaze);
        System.out.println(access);
        System.out.println(Arrays.toString(modules));
        System.out.println("===========visitPackage end===========");
    }

    @Override
    public void visitUse(String service) {
        System.out.println("===========visitPackage===========");
        System.out.println(service);
        System.out.println("===========visitPackage end===========");
    }

    @Override
    public void visitProvide(String service, String... providers) {
        System.out.println("===========visitPackage===========");
        System.out.println(service);
        System.out.println(Arrays.toString(providers));
        System.out.println("===========visitPackage end===========");
    }
}
