package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.message.AbstractCCMessage;
import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.RobotMessage;
import com.study.kefu.v1.entity.message.standard.StandardMessage;
import com.study.kefu.v1.reply.MessageAutoReplyChain;
import com.study.kefu.v1.transfer.MessageTransferChain;

import java.util.List;

public class UserMessageService {

    private MessageSessionService messageSessionService;
    private MessageTransferChain messageTransferChain;
    private MessageSendService messageSendService;
    private MessageAutoReplyChain messageAutoReplyChain;

    public Object obtainUserMessage(AbstractCCMessage ccMessage){
        //获取机器人和用户ID
        String robot, userId;
        if (ccMessage instanceof RobotMessage){
            RobotMessage robotMessage = (RobotMessage) ccMessage;
            robot = robotMessage.getRobotId();
            userId = robotMessage.getUserId();
        }else {
            return null;
        }
        //保存原信息和标准信息放到拦截器中（可以走异步）
        //查询Session
        MessageSession session = messageSessionService.getSession(userId, robot);
        //转换消息格式
        Message forwardMessage = messageTransferChain.transfer(ccMessage, session.getServiceRobot().getPlatform());
        //发送消息
        messageSendService.sendMessageToService(forwardMessage, session);
        //是否有自动回复
        List<StandardMessage> autoReplyMsgs = messageAutoReplyChain.autoReply(ccMessage,
                session.getUserRobot().getPlatform());
        for (StandardMessage autoReplyMsg : autoReplyMsgs) {

        }
        return null;
    }
}
