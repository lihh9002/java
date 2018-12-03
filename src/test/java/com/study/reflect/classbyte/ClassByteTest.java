package com.study.reflect.classbyte;

import com.study.reflect.classbyte.constants.ClassInfo;
import com.study.reflect.classbyte.constants.ConstantPool;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ClassByteTest {
    ByteBuffer buffer = null;

    @Test
    public void readClass2() throws Exception {
        byte[] bytes = FileUtils.readFileToByteArray(new File("C:\\work\\projects\\jiadao-minipro" +
                "\\jiadao-minipro-rest\\target\\test-classes\\com\\tenbent\\jiadao\\minipro\\classbyte\\" +
                "ClassByte.class"));
        ClassByteInfo clazz = ClassByteInfo.readClass(bytes);
        System.out.println(clazz.fields.size());
    }

    @Test
    public void readClass() throws Exception {
        byte[] bytes = FileUtils.readFileToByteArray(new File("C:\\work\\projects\\jiadao-minipro" +
                "\\jiadao-minipro-rest\\target\\classes\\com\\tenbent\\jiadao\\minipro\\service\\event\\" +
                "EventService.class"));
        buffer = ByteBuffer.wrap(bytes);
        //魔数(magic), u4：cafebabe
        for (int i = 0; i < 4; i++) {
            printByteHex();
        }
        println();
        //文件次版本号(minor_version), u2
        printlnShortHex();
        //文件主版本号(major_version), u2
        //1.8: 34 -> 50
        to10(printShortHex());
        //常量池数量(constant_pool_count), u2
        //由于容量计数是从1开始，数量是转换成10十进制之后减一
        ConstantPool.readConstantPool(buffer);
        //访问标志（access_flags), u2
        ElementAccessFlag classAccessFlag = ElementAccessFlag.readClassAccessFlag(buffer);

        //类索引（this_class）, u2
        short _classIndex = HexByteReadUtil.getIndex(buffer);
        ClassInfo classIndex = ConstantPool.getConstant(_classIndex);

        //父类索引（super_class）, u2
        short _superIndex = HexByteReadUtil.getIndex(buffer);
        ClassInfo superIndex = ConstantPool.getConstant(_superIndex);

        //接口计数器（interfaces_count）, u2
        int interface_count = HexByteReadUtil.getCount(buffer);
        System.out.println("实现接口数量：" + interface_count);
        //接口表（interfaces）, u2
        for (int i = 0; i < interface_count; i++) {
            short _interfaceIndex = HexByteReadUtil.getIndex(buffer);
            ClassInfo interfaceIndex = ConstantPool.getConstant(_interfaceIndex);
        }

        //字段计数器（fields_count）, u2
        int fields_count = HexByteReadUtil.getCount(buffer);
        System.out.println("Field数量：" + fields_count);

        //遍历字段
        //#region
        for (int i = 0; i < fields_count; i++) {
            //遍历字段上的属性
            //访问修饰符（access_flags），u2
            int fieldAccessFlag = to10(printShortHex());
            System.out.println("Field Access Flag: " + FieldAccessFlag.flags(fieldAccessFlag));
            //名称索引，name_index，u2
            to10(printShortHex());
            System.out.println("楼上名称索引");
            //descriptor_index, u2
            to10(printShortHex());

            readAttribute();
        }
        //endregion

        //方法计数器(包括构造函数)，（methods_count），u2
        int method_count = to10(printShortHex());
        System.out.println("Method数量：" + method_count);

        //遍历方法
        for (int i = 0; i < method_count; i++) {
            //遍历方法上的属性
            //访问修饰符（access_flags），u2
            int methodAccessFlag = to10(printShortHex());
            System.out.println("Method Access Flag: " + MethodAccessFlag.flags(methodAccessFlag));
            //名称索引，name_index，u2
            to10(printShortHex());
            System.out.println("楼上名称索引");
            //descriptor_index, u2
            to10(printShortHex());

            readAttribute();
        }

        //读取类的属性
        readAttribute();
       if (!buffer.hasRemaining()){
           System.out.println("已读完");
       }else {
           System.out.println("未读完");
       }
    }

    private void readAttribute(){
        //attributes_count
        int attributes_count = to10(printShortHex());
        System.out.println("属性数量：" + attributes_count);

        //attributes
        //遍历属性表
        if (attributes_count > 0){
            for (int j = 0; j < attributes_count; j++) {
                //attribute_name_index
                to10(printShortHex());
                //attribute_length
                int attribute_length = to10(printIntHex());
                System.out.println("楼上是属性长度");
                byte[] abs = new byte[attribute_length];
                buffer.get(abs);
                System.out.println(new String(abs));
            }
        }
    }

    public enum MethodAccessFlag {
        PUBLIC("0001"),
        PRIVATE("0002"),
        PROTECTED("0004"),
        STATIC("0008"),
        FINAL("0010"),
        SYNCHRONIZED("0020"),
        BRIDGE("0040"),
        VARARGS("0080"),
        NATIVE("0100"),
        ABSTRACT("0400"),
        STRICTFP("0800"),
        SYNTHETIC("1000")
        ;
        String flag;

        MethodAccessFlag(String flag) {
            this.flag = flag;
        }

        public int get(){
            return Integer.parseInt(flag, 16);
        }

        public static List<String> flags(int flag){
            List<String> array = new ArrayList<>();
            for (MethodAccessFlag f : values()) {
                if ((flag & f.get()) > 0){
                    array.add(f.name());
                }
            }
            return array;
        }
    }

    public enum FieldAccessFlag {
        PUBLIC("0001"),
        PRIVATE("0002"),
        PROTECTED("0004"),
        STATIC("0008"),
        FINAL("0010"),
        VOLATILE("0040"),
        TRANSIENT("0080"),
        SYNTHETIC("1000"),
        ENUM("4000"),
        ;
        String flag;

        FieldAccessFlag(String flag) {
            this.flag = flag;
        }

        public int get(){
            return Integer.parseInt(flag, 16);
        }

        public static List<String> flags(int flag){
            List<String> array = new ArrayList<>();
            for (FieldAccessFlag f : values()) {
                if ((flag & f.get()) > 0){
                    array.add(f.name());
                }
            }
            return array;
        }
    }

    public enum ClassAccessFlag {
        PUBLIC("0001"),//00000001
        FINAL("0010"),  //00010000
        SUPER("0020"),//00100000
        INTERFACE("0200"),//1000000000
        ABSTRACT("0400"),//10000000000
        SYNTHETIC("1000"),//1000000000000
        ANNOTATION("2000"),//10000000000000
        ENUM("400")//10000000000
        ;
        String flag;

        ClassAccessFlag(String flag) {
            this.flag = flag;
        }

        public int get(){
            return Integer.parseInt(flag, 16);
        }

        public static List<String> flags(int flag){
            List<String> array = new ArrayList<>();
            for (ClassAccessFlag f : values()) {
                if ((flag & f.get()) > 0){
                    array.add(f.name());
                }
            }
            return array;
        }
    }

    private String printByteHex(){
        String hex = Integer.toHexString(buffer.get() & '\u00ff');
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnByteHex(){
        String hex = Integer.toHexString(buffer.get() & '\u00ff');
        System.out.println("[16]" + hex);
        return hex;
    }

    private String printShortHex(){
        String hex = Integer.toHexString(buffer.getShort() & '\uffff');
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnShortHex(){
        String hex = Integer.toHexString(buffer.getShort() & '\uffff');
        System.out.println("[16]" + hex);
        return hex;
    }

    private String printIntHex(){
        String hex = Integer.toHexString(buffer.getInt());
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnIntHex(){
        String hex = Integer.toHexString(buffer.getInt());
        System.out.println("[16]" + hex);
        return hex;
    }

    private String printLongHex(){
        String hex = Long.toHexString(buffer.getLong());
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnLongHex(){
        String hex = Long.toHexString(buffer.getLong());
        System.out.println("[16]" + hex);
        return hex;
    }

    private String printFloatHex(){
        String hex = Float.toHexString(buffer.getFloat());
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnFloatHex(){
        String hex = Float.toHexString(buffer.getFloat());
        System.out.println("[16]" + hex);
        return hex;
    }

    private String printDoubleHex(){
        String hex = Double.toHexString(buffer.getDouble());
        System.out.print("[16]" + hex);
        return hex;
    }

    private String printlnDoubleHex(){
        String hex = Double.toHexString(buffer.getDouble());
        System.out.println("[16]" + hex);
        return hex;
    }

    private void println(){
        System.out.println();
    }

    public int to10(String hex){
        BigInteger bint = new BigInteger(hex, 16);
        System.out.println("[10]" + bint.intValue());
        return bint.intValue();
    }

    public long to10long(String hex){
        Long bint = Long.parseLong(hex, 16);
        System.out.println("[10]" + bint.longValue());
        return bint.longValue();
    }

    public double to10double(String hex){
        Double d = Double.valueOf(hex);
        System.out.println("[10]" + d.doubleValue());
        return d.doubleValue();
    }


    public Object[] constant_pool = null;



    public static Constant utf8_info = Constant.create(
            ConstantItem.create(T.length, U.u2),
            ConstantItem.create(T.bytes, U.u1));

    public static Constant integer_info = Constant.create(
            ConstantItem.create(T.bytes, U.u4));

    public static Constant float_info = Constant.create(
            ConstantItem.create(T.bytes, U.u4)
    );

    public static Constant long_info = Constant.create(
            ConstantItem.create(T.bytes, U.u8)
    );

    public static Constant double_info = Constant.create(
            ConstantItem.create(T.bytes, U.u8)
    );

    public static Constant class_info = Constant.create(
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant string_info = Constant.create(
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant field_ref_info = Constant.create(
            ConstantItem.create(T.index, U.u2),
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant method_ref_info = Constant.create(
            ConstantItem.create(T.index, U.u2),
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant interface_method_ref_info = Constant.create(
            ConstantItem.create(T.index, U.u2),
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant name_and_type_info = Constant.create(
            ConstantItem.create(T.index, U.u2),
            ConstantItem.create(T.index, U.u2)
    );

    public static Constant method_handle_info = Constant.create(
            ConstantItem.create(T.reference_kind, U.u1),
            ConstantItem.create(T.reference_index, U.u2)
    );

    public static Constant invoke_dynamic_info = Constant.create(
            ConstantItem.create(T.bootstrap_method_attr_index, U.u2),
            ConstantItem.create(T.name_and_type_index, U.u2)
    );

    public static Constant[] constants
            = {
            utf8_info, integer_info, float_info, long_info, double_info, class_info,
            string_info, field_ref_info, method_ref_info, interface_method_ref_info,
            name_and_type_info, method_handle_info, invoke_dynamic_info
    };

    public static String getConstantType(int tag){
        switch (tag){
            case 1: return "utf8";
            case 3: return "integer";
            case 4: return "float";
            case 5: return "long";
            case 6: return "double";
            case 7: return "class";
            case 8: return "string";
            case 9: return "field_ref";
            case 10: return "method_ref";
            case 11: return "interface_method_ref";
            case 12: return "name_and_type";
            default:
                throw new RuntimeException("unknown tag: " + tag);
        }
    }

    public static Constant getConstants(int tag) {
        for (Constant constant : constants) {
            if (constant.tag == tag){
                return constant;
            }
        }
        return null;
    }

    public static class Constant{
        public int tag;
        public ConstantItem[] items;

        public Constant(U tag, ConstantItem... items) {
            this.tag = tag.v;
            this.items = items;
        }

        public static Constant create(ConstantItem... items){
            return new Constant(U.u1, items);
        }
    }

    public static class ConstantItem{
        public T t;
        public U u;

        public ConstantItem(T t, U u) {
            this.t = t;
            this.u = u;
        }

        public static ConstantItem create(T t, U u){
            return new ConstantItem(t, u);
        }
    }

    public enum U{
        u1(1), u2(2), u4(4), u8(8)
        ;
        public int v;

        U(int v) {
            this.v = v;
        }
    }

    public enum T{
        length, bytes, index,
        reference_kind, reference_index,
        descriptor_index,
        bootstrap_method_attr_index,
        name_and_type_index
    }
}
