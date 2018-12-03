package com.study.reflect.classbyte.constants;

import com.study.reflect.classbyte.HexByteReadUtil;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class ConstantPool {

    private static Map<Short, BaseConstant> constants;

    public static Map<Short, BaseConstant> readConstantPool(ByteBuffer buffer){
        //读取常量池数量
        int constantCount = HexByteReadUtil.getCount(buffer);
        //实际数量是 - 1
        constantCount = constantCount - 1;
        constants = new HashMap<>(constantCount);
        //从1开始遍历常量池
        for (short index = 1; index <= constantCount; index++) {
            //读取Tag
            short tag = HexByteReadUtil.getTag(buffer);
            BaseConstant constant;
            switch (tag){
                case 1:
                    constant = new Utf8Info();
                    break;
                case 3:
                    constant = new IntegerInfo();
                    break;
                case 4:
                    constant = new FloatInfo();
                    break;
                case 5:
                    constant = new LongInfo();
                    break;
                case 6:
                    constant = new DoubleInfo();
                    break;
                case 7:
                    constant = new ClassInfo();
                    break;
                case 8:
                    constant = new StringInfo();
                    break;
                case 9:
                    constant = new FieldRefInfo();
                    break;
                case 10:
                    constant = new MethodRefInfo();
                    break;
                case 11:
                    constant = new InterfaceMethodRefInfo();
                    break;
                case 12:
                    constant = new NameAndTypeInfo();
                    break;
                case 15:
                    constant = new MethodHandleInfo();
                    break;
                case 16:
                    constant = new MethodTypeInfo();
                    break;
                default:
                    throw new RuntimeException("unknown tag: " + tag);
            }
            constant.read(buffer);
            constant.idx = index;
            constant.tag = tag;
            constants.put(index, constant);
            //long 和 double类型占两个索引，JVM规范中规定
            if (tag == 5 || tag == 6){
                index++;
            }
        }
        return constants;
    }

    public static <T extends BaseConstant> T getConstant(short index){
        return (T) constants.get(index);
    }
}
