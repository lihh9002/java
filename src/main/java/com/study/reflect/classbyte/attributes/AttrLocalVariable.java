package com.study.reflect.classbyte.attributes;

import com.study.reflect.classbyte.HexByteReadUtil;
import com.study.reflect.classbyte.constants.ConstantPool;
import com.study.reflect.classbyte.constants.Utf8Info;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AttrLocalVariable extends AttributeInfo{

    public List<LocalVariable> variables;

    @Override
    public void readAttribute(ByteBuffer buffer) {
        this.variables = LocalVariable.readVariables(buffer);
    }

    public static class LocalVariable{
        public short startPc;//生命周期开始位置
        public short region;//作用范围覆盖长度
        public Utf8Info name;//局部变量名称
        public Utf8Info descriptor;//局部变量描述符
        public short index;//在栈帧局表变量表中的Slot的位置

        public static List<LocalVariable> readVariables(ByteBuffer buffer){
            short count = HexByteReadUtil.getCount(buffer);
            List<LocalVariable> variables = new ArrayList<>(count);
            for (short i = 0; i < count; i++) {
                LocalVariable variable = new LocalVariable();
                variable.startPc = HexByteReadUtil.getShort(buffer);
                variable.region = HexByteReadUtil.getShort(buffer);
                variable.name = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
                variable.descriptor = ConstantPool.getConstant(HexByteReadUtil.getIndex(buffer));
                variable.index = HexByteReadUtil.getShort(buffer);
                variables.add(variable);
            }
            return variables;
        }
    }
}
