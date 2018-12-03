package com.study.reflect.type;

import java.lang.reflect.*;

public class TypeDetermine {

    public static void whichType(Type type, int dept){
        if (type instanceof WildcardType){
            println(type + " is Wildcard Type", dept);
            WildcardType wtype = WildcardType.class.cast(type);
            println("[WildcardType]UpperBounds : ", dept);
            for (Type t : wtype.getUpperBounds()) {
                whichType(t, dept + 1);
            }
            println("[WildcardType]LowerBounds : ", dept);
            for (Type t : wtype.getLowerBounds()) {
                whichType(t, dept + 1);
            }
        }else if (type instanceof TypeVariable){
            println(type + " is Type Variable", dept);
            TypeVariable ttype = TypeVariable.class.cast(type);
            println(type + " name is " + ttype.getName(), dept);
            println(type + " genericDeclaration is " + ttype.getGenericDeclaration(), dept);
            println("[TypeVariable]Bounds : ", dept);
            for (Type t : ttype.getBounds()) {
                whichType(t, dept + 1);
            }
        }else if (type instanceof ParameterizedType){
            println(type + " is Parameterized Type", dept);
            ParameterizedType ptype = ParameterizedType.class.cast(type);
            println("[ParameterizedType]Raw Type : ", dept);
            whichType(ptype.getRawType(), dept + 1);
            println("[ParameterizedType]Owner Type : ", dept);
            whichType(ptype.getOwnerType(), dept + 1);
            println("[ParameterizedType]Actual Type Arguments : ", dept);
            for (Type t : ptype.getActualTypeArguments()) {
                whichType(t, dept + 1);
            }
        }else if (type instanceof GenericArrayType){
            println(type + " is Generic Array Type", dept);
            GenericArrayType gtype = GenericArrayType.class.cast(type);
            println("[GenericArrayType]Generic Component Type : ", dept);
            whichType(gtype.getGenericComponentType(), dept + 1);
        }else if (type instanceof Class){
            println(type + " is Class", dept);
        }else if (type != null){
            println(type + " unknown type", dept);
        }else {
            println("type is null", dept);
        }

        println("-------------end------------------", dept);
    }

    private static void println(String msg, int dept){
        for (int i = 0; i < dept; i++) {
            System.out.print("\t");
        }
        System.out.println(msg);
    }
}
