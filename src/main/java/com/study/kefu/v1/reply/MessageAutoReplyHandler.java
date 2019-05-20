package com.study.kefu.v1.reply;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.standard.StandardMessage;

public interface MessageAutoReplyHandler {

    /**
     * 自动回复消息
     * @param message
     * @param session
     * @return
     */
    StandardMessage autoReply(Message message, MessageSession session);
}
