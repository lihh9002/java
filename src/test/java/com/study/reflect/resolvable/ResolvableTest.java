package com.study.reflect.resolvable;

import com.study.reflect.asm.visit.AsmClassInfo;
import com.study.reflect.type.TypeAnnotatedTestClass;
import org.apache.commons.collections.ArrayStack;
import org.junit.Test;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResolvableTest {


    @Test
    public void testField()throws Exception{
        System.out.println(System.getProperty("org.graalvm.nativeimage.imagecode"));
        System.out.println(Serializable.class.isAssignableFrom(Class.class));
        Field ls = TypeAnnotatedTestClass.class.getField("ls");
        ResolvableType lsType = ResolvableType.forField(ls);
        lsType.asCollection();
        Number n = 1;
        ArrayList list = new ArrayList();
        List proxy = (List) Proxy.newProxyInstance(ResolvableTest.class.getClassLoader(), new Class[]{
                List.class, Serializable.class
        }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        System.out.println(ClassUtils.getDescriptiveType(proxy));
        System.out.println(Map.Entry.class.getSimpleName());
        System.out.println(proxy.getClass().getTypeName());
        System.out.println(ClassUtils.getShortName(proxy.getClass().getTypeName()));
        System.out.println(ClassUtils.getShortName(Map.Entry[].class.getTypeName()));

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AsmClassInfo.class);
        enhancer.setCallback(
                (MethodInterceptor) (o, method, objects, methodProxy) -> null
        );
        Object clazz = enhancer.create();
        System.out.println(clazz.getClass().getTypeName());

        Class c = ClassUtils.forName(clazz.getClass().getTypeName() + "[]", null);
        System.out.println(c.getTypeName());
        System.out.println(c.getName());
        System.out.println(ClassUtils.getShortName(c));
        System.out.println(ClassUtils.getShortNameAsProperty(Map.Entry[].class));

        System.out.println(ClassUtils.getMethodCountForName(ArrayList.class, "add"));

        System.out.println(ReflectionUtils.findMethod(ArrayStack.class, "outOfBoundsMsg", int.class));
    }

    @Test
    public void testResolvable(){
        ResolvableType resolvable = ResolvableType.forClass(ResolvableBean.class);
        System.out.println(resolvable.getGeneric(0).resolve());
    }

    @Test
    public void testWD(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);

        int r = 1 + 2 * 3 - 4;
        System.out.println(r);

        List<String> list = new ArrayList<>();

        System.out.println(StringUtils.cleanPath("C:\\work\\桌面文档\\a\\.."));

        ResolvableBean bean = new ResolvableBean();

        Class clazz
                = GenericTypeResolver.resolveTypeArgument(bean.getClass(), ArrayList.class);
        System.out.println(clazz);
    }

    @Test
    public void resolve(){
        Class clazz = Void.class;
        ResolvableType rtype = ResolvableType.forClass(clazz);
        Class rclazz = rtype.resolve();
        System.out.println(rclazz);
        System.out.println(rclazz.isPrimitive());
        if(rclazz.isPrimitive()){
            Object array = Array.newInstance(rclazz, 1);
            Class<?> wrapperType = Array.get(array, 0).getClass();
            System.out.println(wrapperType);
            rtype = ResolvableType.forClass(wrapperType);
            System.out.println(rtype);
        }
    }

    @Test
    public void propertyName(){
        String pname = "[abc.xyz].[m.n]";
        pname = "a.[b][c]";
        ConfigurationPropertyName name = ConfigurationPropertyName.of(pname);
        System.out.println(name);
    }
}
