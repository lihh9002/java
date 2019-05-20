package com.study.im;

import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.netease.api.NeteaseApiMessage;
import com.study.kefu.v1.entity.message.netease.cc.NeteaseCCMessage;
import com.study.kefu.v1.entity.message.standard.StandardMessage;
import com.study.kefu.v1.transfer.MessageTransfer;
import com.study.kefu.v1.transfer.impl.NeteaseCC2StandardMessageTransfer;
import org.junit.Test;

public class MessageTransferTest {

    @Test
    public void transfer(){
        MessageTransfer transfer = new NeteaseCC2StandardMessageTransfer();
        Message message = new NeteaseCCMessage();
        Message msg = transfer.transfer(message, StandardMessage.FORMAT);
        System.out.println(msg);
    }
}
