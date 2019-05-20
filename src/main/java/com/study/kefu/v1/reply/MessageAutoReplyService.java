package com.study.kefu.v1.reply;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.AbstractApiMessage;
import com.study.kefu.v1.entity.message.AbstractReplyMessage;
import com.study.kefu.v1.entity.message.standard.StandardMessage;
import com.study.kefu.v1.service.MessageSendService;
import com.study.kefu.v1.transfer.MessageTransferChain;

public class MessageAutoReplyService {

    private MessageTransferChain messageTransferChain = new MessageTransferChain();
    private MessageSendService messageSendService = new MessageSendService();

    public void autoReply(StandardMessage message, MessageSession session){
        //转换回复消息的标准消息
        StandardMessage replyStandard = (StandardMessage) messageTransferChain.transfer(message, AbstractReplyMessage.FORMAT);
        //todo: 保存标准消息

        //转成自动回复的消息格式
        AbstractApiMessage replyMessage
                = (AbstractApiMessage) messageTransferChain.transfer(replyStandard, session.getUserRobot().getPlatform());
        //发送自动回复消息
        messageSendService.sendMessageToService(replyMessage, session);

        //将自动消息转回给客服
        AbstractApiMessage ccReplyMessage
                = (AbstractApiMessage) messageTransferChain.transfer(replyStandard, session.getServiceRobot().getPlatform());
        //发送自动回复消息
        messageSendService.sendMessageToService(ccReplyMessage, session);

    }
}
