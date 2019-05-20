package com.study.kefu.v1.transfer;

import com.study.kefu.v1.entity.message.Message;

import java.util.LinkedList;
import java.util.List;

public class MessageTransferChain implements MessageTransfer{

    private List<MessageTransfer> transfers = new LinkedList<>();

    @Override
    public Message transfer(Message sourceMsg, String direction) {
        for (MessageTransfer transfer : transfers) {
            Message target = transfer.transfer(sourceMsg, direction);
            if (target != null){
                return target;
            }
        }
        throw new RuntimeException("该消息格式不支持转换");
    }
}
