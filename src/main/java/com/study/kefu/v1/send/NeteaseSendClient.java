package com.study.kefu.v1.send;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.netease.api.NeteaseApiMessage;

public class NeteaseSendClient extends MessageSendClient<NeteaseApiMessage> {

    @Override
    protected void send(NeteaseApiMessage message, MessageSession session) {

    }
}
