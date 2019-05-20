package com.study.kefu.v1.send;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.AbstractApiMessage;
import com.study.kefu.v1.support.GenericMethodMatcher;

public abstract class MessageSendClient<T extends AbstractApiMessage> implements GenericMethodMatcher<T> {

    public boolean sendMessage(T message, MessageSession session){
        if (!this.typeMatch(message)){
            return false;
        }
        send(message, session);
        return true;
    }

    protected abstract void send(T message, MessageSession session);
}
