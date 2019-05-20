package com.study.kefu.v0;

import java.util.Date;

public class CSBean {
}

/**
 * 标准消息
 */
class StandardMessage{
    public long id;
    public String fromId;
    public String toId;

    public String type;
    public String text;
    public StandMessageBody body;

    public StandMessageBody getBody() {
        return body;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }
}

/**
 * 抄送消息
 */
abstract class RobotMessage{
    protected String userId;
    protected String robotId;

    public String getUserId() {
        return userId;
    }

    public String getRobotId() {
        return robotId;
    }
}



/**
 * 消息体
 */
class StandMessageBody{

}

/**
 * 机器人
 */
class Robot{
    //自增ID，从8000开始，用来存储数据的表
    public int id;
    //平台：小程序客服（minipro），公众号(public)，云信(netease)
    public String platform;
    //如果是小程序客服或公众号，则是AppId，如果是云信，则是云信的特殊账户ID
    public String robotId;
    //角色：用户，客服
    public String role;
}

/**
 * 用户机器人和客服机器人的绑定
 */
class RobotBind{
    //用户机器人
    public String user;
    //客服机器人
    public String service;
}

/**
 * 消息回话
 */
class MessageSession{
    //uuid
    public String sessionId;
    public String userId;
    public String serviceId;
    //1、正常，0、待接，-1、暂停，-2，切换
    public int status;
    //用户机器人
    public String userRobot;
    public String userRobotPlatform;
    //客服机器人
    public String serviceRobot;
    public String serviceRobotPlatform;
}

/**
 * 客服
 */
class CustomerService{
    //客服ID
    public String id;
    //状态（在线：1，离线：-1）
    public int status;
}

/**
 * 客服注册信息
 */
class CustomerServiceRegister{
    //客服ID
    public String userName;
    //注册密码
    public String password;
    //机器人ID
    public String robotId;
    //注册时间
    public Date registerDate;
}
