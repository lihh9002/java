package com.study.kefu.v1.transfer;

import com.study.kefu.v1.entity.message.Message;
import org.springframework.lang.NonNull;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractMessageTransfer<T extends Message> implements MessageTransfer{

    @Override
    public Message transfer(Message sourceMsg, String direction) {
        if (this.typeMatch(sourceMsg) && this.support(sourceMsg, direction)){
            return transfer((T)sourceMsg);
        }
        return null;
    }

    protected abstract boolean support(Message sourceMsg, String direction);

    /**
     * @param sourceMsg
     * @return
     */
    protected abstract @NonNull Message transfer(@NonNull T sourceMsg);

    /**
     * 获取实现类的泛型类型
     * @return
     */
    private Class<T> getGenericType(){
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * 是否类型匹配
     * @param sourceMsg
     * @return
     */
    private boolean typeMatch(Message sourceMsg){
        return sourceMsg.getClass().equals(getGenericType());
    }
}
