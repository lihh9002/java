package com.study.kefu.v1.transfer;

import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.support.GenericMethodMatcher;
import org.springframework.lang.NonNull;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractMessageTransfer<T extends Message> implements MessageTransfer, GenericMethodMatcher<T> {

    @Override
    public Message transfer(Message sourceMsg, String direction) {
        if (this.typeMatch((T) sourceMsg) && this.support(sourceMsg, direction)){
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

}
