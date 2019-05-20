package com.study.kefu.v1.transfer.impl;

import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.netease.api.NeteaseApiMessage;
import com.study.kefu.v1.entity.message.netease.cc.NeteaseCCMessage;
import com.study.kefu.v1.entity.message.standard.StandardMessage;
import com.study.kefu.v1.transfer.AbstractMessageTransfer;

public class NeteaseCC2StandardMessageTransfer extends AbstractMessageTransfer<NeteaseCCMessage> {
    @Override
    protected boolean support(Message sourceMsg, String direction) {
        return direction.equals(StandardMessage.FORMAT);
    }

    @Override
    protected Message transfer(NeteaseCCMessage sourceMsg) {
        StandardMessage message = new StandardMessage();
        return message;
    }
}
