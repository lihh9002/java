package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.AbstractApiMessage;
import com.study.kefu.v1.send.MessageSendClient;

import java.util.List;

public class MessageSendService {

    private List<MessageSendClient> messageSendClients;

    /**
     * 发送消息给客服
     */
    public void sendMessageToService(AbstractApiMessage message, MessageSession session){
        for (MessageSendClient sendClient : messageSendClients) {
            if (sendClient.sendMessage(message, session));
        }
    }
}
