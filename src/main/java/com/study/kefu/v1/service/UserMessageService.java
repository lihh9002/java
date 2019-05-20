package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.AbstractApiMessage;
import com.study.kefu.v1.entity.message.AbstractCCMessage;
import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.standard.StandardMessage;
import com.study.kefu.v1.reply.MessageAutoReplyService;
import com.study.kefu.v1.transfer.MessageTransferChain;

public class UserMessageService {

    private MessageSessionService messageSessionService;
    private MessageTransferChain messageTransferChain;
    private MessageSendService messageSendService;
    private MessageAutoReplyService messageAutoReplyService;

    public void obtainUserMessage(AbstractCCMessage ccMessage){
        //获取机器人和用户ID
        String robot = ccMessage.getToId();
        String userId = ccMessage.getFromId();
        //保存原信息和标准信息放到拦截器中（可以走异步）
        StandardMessage standardMessage
                = (StandardMessage) messageTransferChain.transfer(ccMessage, StandardMessage.FORMAT);
        // TODO: 2019/5/20 保存标准消息
        //查询Session
        MessageSession session = messageSessionService.getSession(userId, robot);
        //转换消息格式
        AbstractApiMessage forwardMessage
                = (AbstractApiMessage) messageTransferChain.transfer(ccMessage, session.getServiceRobot().getPlatform());
        //发送消息
        messageSendService.sendMessageToService(forwardMessage, session);
        //是否有自动回复
        messageAutoReplyService.autoReply(standardMessage, session);
    }
}
