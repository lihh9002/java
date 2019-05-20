package com.study.kefu.v0;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息转换
 * @param <S>
 * @param <T>
 */
public interface MessageConverter<S, T> {
    T convert(S originMessage);
}

interface MessageParser<T> extends MessageConverter<String, T>{

}

/**
 * 标准消息转换
 * @param <S>
 */
interface StandardMessageConverter<S> extends MessageConverter<S, StandardMessage>{

}

class MessageHandleService{

    public void handle(){

    }
}

interface UserMessageInterceptor<S, T>{
    /**
     * 接收到抄送的消息
     * @param originMsg
     */
    void afterCopy(S originMsg);

    /**
     * 转发消息之前
     * @param forwardMsg
     */
    void beforeForward(T forwardMsg);

    /**
     * 转发消息之后
     * @param forwardMsg
     */
    void afterForward(T forwardMsg);

    /**
     * 消息转发异常
     * @param ex
     * @param forwardMsg
     */
    void forwardError(Exception ex, T forwardMsg);
}

class UserMessageService<S extends RobotMessage, T extends RobotMessage>{

    private MessageParser<S> messageParser;
    private StandardMessageConverter<S> standardMessageConverter;
    private MessageConverter<S, T> messageConverter;
    private MessageAutoReplyService messageAutoReplyService;
    private MessageSessionService messageSessionService;
    private MessageSendService<T> messageSendService;
    private List<UserMessageInterceptor<S, T>> messageInterceptors = new ArrayList<>();

    public void handle(String userMsgStr){
        //解析原始消息
        S originMsg = messageParser.convert(userMsgStr);
        //拦截器
        this.afterCopy(originMsg);
        //将解析的原始消息存储数据库
        this.saveOriginMsg(originMsg);
        //将原始消息转换成标准消息
        StandardMessage standardMessage = standardMessageConverter.convert(originMsg);
        this.saveStandardMsg(standardMessage);


        //处理转发的逻辑
        String robot = originMsg.getRobotId();
        String userId = originMsg.getUserId();
        //查询会话
        MessageSession session = messageSessionService.getSessionByUserId(userId);
        if (session == null){
            //如果不存在，创建新的会话
            session = messageSessionService.createSession(userId, robot);
        }
        if (session.serviceId == null){
            //如果没有绑定客服
        }
        if (!session.userRobot.equals(robot)){
            //如果回话机器人不一致
        }





        //转换成接收方消息格式
        T forwardMsg = messageConverter.convert(originMsg);
        //拦截器
        this.beforeForward(forwardMsg);
        this.saveForwardMsg(forwardMsg);
        //记录转发记录
        MessageForwardInfo forwardInfo = this.forward(originMsg, forwardMsg);

        //转发消息
        try {
            messageSendService.sendMessage(forwardMsg);
        }catch (Exception ex){
            this.forwardError(ex, forwardMsg);
        }
        //记录消息转发

        //拦截器
        this.afterForward(forwardMsg);
        //处理自动回复消息
        messageAutoReplyService.autoReply(standardMessage);
    }

    //region private method
    private void afterCopy(S originMsg){
        for (UserMessageInterceptor<S, T> interceptor : messageInterceptors) {
            interceptor.afterCopy(originMsg);
        }
    }

    private void beforeForward(T forwardMsg){
        for (UserMessageInterceptor<S, T> interceptor : messageInterceptors) {
            interceptor.beforeForward(forwardMsg);
        }
    }

    private void afterForward(T forwardMsg){
        for (UserMessageInterceptor<S, T> interceptor : messageInterceptors) {
            interceptor.afterForward(forwardMsg);
        }
    }

    private void forwardError(Exception ex, T forwardMsg){
        for (UserMessageInterceptor<S, T> interceptor : messageInterceptors) {
            interceptor.forwardError(ex, forwardMsg);
        }
    }

    /**
     * 将解析的原始消息存储数据库
     * @param originMsg
     */
    protected void saveOriginMsg(S originMsg){

    }

    /**
     * 保存标准消息
     * @param standardMessage
     */
    protected void saveStandardMsg(StandardMessage standardMessage){

    }

    /**
     * 保存转成的待转发的消息
     * @param forwardMessage
     */
    protected void saveForwardMsg(T forwardMessage){

    }

    protected MessageForwardInfo forward(S originMsg, T forwardMsg){
        return new MessageForwardInfo();
    }
    //endregion
}

interface CustomerServiceService{
    /**
     * 根据客服机器人确定具体的客服ID
     * @param serverRobot
     * @return
     */
    CustomerService getService(String serverRobot);
}

class DefaultCustomerServiceService implements CustomerServiceService{

    @Override
    public CustomerService getService(String serverRobot) {
        //todo: 调用API获取客服
        CustomerService customerService = new CustomerService();
        return customerService;
    }

    private void register(CustomerService customerService){
        //
    }
}


class CsMessageService<S, T>{
    private MessageParser<S> messageParser;
    private StandardMessageConverter<S> standardMessageConverter;
    private MessageConverter<S, T> messageConverter;
    private MessageAutoReplyService messageAutoReplyService;
    private MessageSessionService messageSessionService;
    private MessageSendService<T> messageSendService;
    private List<UserMessageInterceptor<S, T>> messageInterceptors = new ArrayList<>();

    public void handle(String csMsgStr){
        //解析原始消息
        S originMsg = messageParser.convert(csMsgStr);
        //将解析的原始消息存储数据库
        this.saveOriginMsg(originMsg);
        //将原始消息转换成标准消息
        StandardMessage standardMessage = standardMessageConverter.convert(originMsg);
        this.saveStandardMsg(standardMessage);
        //处理转发的逻辑
        //转换成接收方消息格式
        T forwardMsg = messageConverter.convert(originMsg);
        //拦截器
        this.saveForwardMsg(forwardMsg);
        //记录转发记录
        MessageForwardInfo forwardInfo = this.forward(originMsg, forwardMsg);
        //从抄送的原始消息中获取SessionId（利用云信的自定义处理）
        String sessionId = null;
        MessageSession session = messageSessionService.getBySessionId(sessionId);
        //转发消息
        messageSendService.sendMessage(forwardMsg);
        //记录消息转发

    }

    /**
     * 将解析的原始消息存储数据库
     * @param originMsg
     */
    protected void saveOriginMsg(S originMsg){

    }

    /**
     * 保存标准消息
     * @param standardMessage
     */
    protected void saveStandardMsg(StandardMessage standardMessage){

    }

    /**
     * 保存转成的待转发的消息
     * @param forwardMessage
     */
    protected void saveForwardMsg(T forwardMessage){

    }

    protected MessageForwardInfo forward(S originMsg, T forwardMsg){
        return new MessageForwardInfo();
    }


}

class MessageSessionService{

    private RobotBindService robotBindService;
    private RobotService robotService;

    /**
     * 根据用户ID查询正常状态下的Session
     * @param userId
     * @return
     */
    public MessageSession getSessionByUserId(String userId){
        return new MessageSession();
    }

    /**
     * 根据SessionId查询Session
     * @param sessionId
     * @return
     */
    public MessageSession getBySessionId(String sessionId){
        return new MessageSession();
    }

    /**
     * 创建新Session
     * @param userId
     * @return
     */
    public MessageSession createSession(String userId, String userRobot){
        MessageSession session = new MessageSession();
        session.sessionId = "random";
        session.userId = userId;
        session.status = 0;
        session.userRobot = userRobot;
        robotService.getByRobotId(userRobot);

        //查询绑定的客服机器人，消息通过该机器人转发
        RobotBind robotBind = robotBindService.getBind(userRobot);
        session.serviceRobot = robotBind.service;
        return session;
    }
}

class RobotService{
    public Robot getByRobotId(String robotId){
        return new Robot();
    }
}

class RobotBindService{
    public RobotBind getBind(String userRobot){
        return new RobotBind();
    }
}

class MessageForwardInfo{

}

class MessageAutoReplyService{
    private List<MessageAutoReplyHandler> autoReplyHandlers;

    public void autoReply(StandardMessage message){
        for (MessageAutoReplyHandler autoReplyHandler : this.autoReplyHandlers) {
            if (autoReplyHandler.reply(message.getBody())){
                autoReplyHandler.doReply(message);
            }
        }
    }
}

/**
 * 自动回复
 */
abstract class MessageAutoReplyHandler{

    public abstract boolean reply(StandMessageBody messageBody);

    public abstract void doReply(StandardMessage message);


}

interface MessageSendService<T>{

    void sendMessage(T message);
}