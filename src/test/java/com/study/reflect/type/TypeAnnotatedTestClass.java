package com.study.reflect.type;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TypeAnnotatedTestClass<@TestAnn(site="classTypeParameter") S extends @TestAnn(site = "D")Date,T>
        extends @TestAnn(site="extends") Thread
        implements @TestAnn(site="implements") Runnable {

    public @TestAnn(site="field") boolean typeAnnotatedBoolean;

    public @TestAnn(site="inner") TypeAnnotatedTestClass typeAnnotatedInner;

    public @TestAnn(site = "array") String[] msg;

    public @TestAnn(site = "S") S s;

    public @TestAnn(site = "LS") List<@TestAnn(site = "IS")S> ls;

    public
    @TestAnn(site="array4") boolean
    @TestAnn(site="array1") []
    @TestAnn(site="array2") []
    @TestAnn(site="array3") []
            typeAnnotatedArray;

    public @TestAnn(site="map1") Map<@TestAnn(site="map2") ? extends @TestAnn(site="map3") String,
                        @TestAnn(site="map4") List<@TestAnn(site="map5")  Object>> typeAnnotatedMap;

    public int dummy1;
    public int dummy2;
    public int dummy3;

    @TestAnn(site="return") <@TestAnn(site="methodTypeParameter") U,V>
    Class typeAnnotatedMethod(@TestAnn(site="formalParameter") TypeAnnotatedTestClass arg)
            throws @TestAnn(site="throws") ClassNotFoundException {

        @TestAnn(site="local_variable_type") int foo = 0;
        throw new ClassNotFoundException();
    }

    public void run() {}
}
