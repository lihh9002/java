package com.study.reflect.type;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TypeStudy<T extends Annotation> {

    public List<String> list;
    public Map<String, Integer> map;
    public Map<String, List<? extends Number>> map2;
    public List<String>[] arr;
    public Map<Inner<? super T>, List<? extends Number>>[] maps;
    public Integer[] ints;
    public List<? extends Number> number;
    public Class<?> clazz;
    public Map<String, T> map3;
    public List list2;
    public String str;
    public int a;

    public class Inner<T>{

    }

    public class A{}

    public class B extends A{}

    public class C extends B{}

    @Test
    public void studyAnnotation()throws Exception{
        Class clazz = TypeAnnotatedTestClass.class;
        AnnotatedType superclassAnno = clazz.getAnnotatedSuperclass();
        showAnnoType(superclassAnno);

        AnnotatedType[] interfaceAnnos = clazz.getAnnotatedInterfaces();
        showAnnoType(interfaceAnnos);

        TypeVariable<Class<TypeAnnotatedTestClass>>[] clazzTypeParameters = clazz.getTypeParameters();
        for (TypeVariable<Class<TypeAnnotatedTestClass>> tp : clazzTypeParameters) {
            System.out.println(tp);
            Annotation[] tpAnnos = tp.getAnnotations();
            for (Annotation tpAnno : tpAnnos) {
                System.out.println(tpAnno);
            }
        }

        Field bf = clazz.getField("typeAnnotatedBoolean");
        showAnnoType(bf.getAnnotatedType());

        Field tf = clazz.getField("typeAnnotatedInner");
        showAnnoType(tf.getAnnotatedType());

        Field msg = clazz.getField("msg");
        showAnnoType(msg.getAnnotatedType());

        System.out.println("S:");
        Field s = clazz.getField("s");
        showAnnoType(s.getAnnotatedType());
        AnnotatedTypeVariable apv = AnnotatedTypeVariable.class.cast(s.getAnnotatedType());
        showAnnoType(apv.getAnnotatedBounds());

        System.out.println("LS:");
        Field ls = clazz.getField("ls");
        showAnnoType(ls.getAnnotatedType());
        AnnotatedParameterizedType apt1 = (AnnotatedParameterizedType) ls.getAnnotatedType();
        showAnnoType(apt1.getAnnotatedActualTypeArguments());
        apv = AnnotatedTypeVariable.class.cast(apt1.getAnnotatedActualTypeArguments()[0]);
        System.out.println("APV:");
        showAnnoType(apv.getAnnotatedBounds());

        System.out.println("以下是typeAnnotatedArray的注解");
        Field field = clazz.getField("typeAnnotatedArray");

        AnnotatedArrayType arrType = (AnnotatedArrayType) field.getAnnotatedType();
        showAnnoType(arrType);
        AnnotatedArrayType arrType2 = (AnnotatedArrayType) arrType.getAnnotatedGenericComponentType();
        showAnnoType(arrType2);
        AnnotatedArrayType arrType3 = (AnnotatedArrayType) arrType2.getAnnotatedGenericComponentType();
        showAnnoType(arrType3);

        Field mapField = clazz.getField("typeAnnotatedMap");
        AnnotatedParameterizedType apt = AnnotatedParameterizedType.class.cast(mapField.getAnnotatedType());
        showAnnoType(apt);
        AnnotatedType[] aatas = apt.getAnnotatedActualTypeArguments();
        showAnnoType(aatas);

        System.out.println("----------------------");
        AnnotatedWildcardType awt = AnnotatedWildcardType.class.cast(aatas[0]);
        showAnnoType(awt.getAnnotatedLowerBounds());
        showAnnoType(awt.getAnnotatedUpperBounds());
        AnnotatedParameterizedType apt2 = AnnotatedParameterizedType.class.cast(aatas[1]);
        showAnnoType(apt2.getAnnotatedActualTypeArguments());

        Method method = clazz.getDeclaredMethod("typeAnnotatedMethod", TypeAnnotatedTestClass.class);
        method.setAccessible(true);
        System.out.println("return type");
        showAnnoType(method.getAnnotatedReturnType());
        System.out.println("receiver type");
        showAnnoType(method.getAnnotatedReceiverType());
        System.out.println("parameter type");
        showAnnoType(method.getAnnotatedParameterTypes());
        System.out.println("exception type");
        showAnnoType(method.getAnnotatedExceptionTypes());

        TypeVariable<Method>[] vars = method.getTypeParameters();
        System.out.println(Arrays.toString(vars));

        showAnnoType(vars[0].getAnnotatedBounds());
        System.out.println(Arrays.toString(vars[0].getAnnotations()));

    }

    private void showAnnoType(AnnotatedType... annoTypes){
        for (AnnotatedType type : annoTypes) {
            if (type == null){
                System.out.println("type is null");
            }
            System.out.println(type.getClass());
            System.out.println(type.getType());
            for (Annotation anno : type.getAnnotations()) {
                System.out.println(anno);
            }
        }
        System.out.println("**************************");
    }

    @Test
    public void studyType()throws Exception{
        Field field = TypeStudy.class.getDeclaredField("maps");
        TypeDetermine.whichType(field.getGenericType(), 0);

//        field = TypeStudy.class.getDeclaredField("maps");
//        TypeDetermine.whichType(field.getGenericType(), 0);

//        field = TypeStudy.class.getDeclaredField("arr");,,
//        TypeDetermine.whichType(field.getGenericType());
//
//        field = TypeStudy.class.getDeclaredField("ints");
//        TypeDetermine.whichType(field.getGenericType());
//
//        field = TypeStudy.class.getDeclaredField("number");
//        TypeDetermine.whichType(field.getGenericType());

//        Method method = TypeStudy.class.getDeclaredMethod("wildcard", List.class);
//        TypeDetermine.whichType(method.getGenericParameterTypes()[0], 0);
    }

    public static void wildcard(List<? extends Number> arg){

    }

    public static void wildcard2(List<Number> arg){

    }

    public static void wildcard3(List<? super Date> arg){

    }
}
