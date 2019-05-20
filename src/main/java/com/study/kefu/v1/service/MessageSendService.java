package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.Robot;
import com.study.kefu.v1.entity.message.Message;

public class MessageSendService {

    /**
     * 发送消息给客服
     */
    public void sendMessageToService(Message message, MessageSession session){
        switch (session.getServiceRobot().getPlatform()){
            /*case Robot.PLATFORM_MINIPRO:
                // TODO: 2019/5/18 小程序客服发送
                break;
            case Robot.PLATFORM_PUBLIC:
                // TODO: 2019/5/18 公众号客服发送
                break;*/
            case Robot.PLATFORM_NETEASE:
                // TODO: 2019/5/18 网易云信发送
                break;
            default:
                throw new RuntimeException("不支持的消息平台");
        }
    }

    /**
     * 发送消息给用户
     * @param message
     * @param session
     */
    public void sendMessageToUser(Message message, MessageSession session){
        switch (session.getServiceRobot().getPlatform()){
            case Robot.PLATFORM_MINIPRO:
                // TODO: 2019/5/18 小程序客服发送
                break;
            case Robot.PLATFORM_PUBLIC:
                // TODO: 2019/5/18 公众号客服发送
                break;
            case Robot.PLATFORM_NETEASE:
                // TODO: 2019/5/18 网易云信发送
                break;
            default:
                throw new RuntimeException("不支持的消息平台");
        }
    }
}
