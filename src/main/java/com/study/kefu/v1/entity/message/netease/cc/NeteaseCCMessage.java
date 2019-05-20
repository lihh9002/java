package com.study.kefu.v1.entity.message.netease.cc;

import com.study.kefu.v1.entity.message.AbstractCCMessage;
import com.study.kefu.v1.entity.message.RobotMessage;

public class NeteaseCCMessage extends AbstractCCMessage implements RobotMessage {

    //PERSON或CUSTOM_PERSON
    private String convType;
    //消息发送者的用户账号，字符串类型
    private String fromAccount;
    //发送方昵称，字符串类型
    private String fromNick;
    //消息发送时间，字符串类型
    private String msgTimestamp;
    //TEXT、
    //PICTURE、
    //AUDIO、 //后续支持
    //VIDEO、
    //LOCATION 、 //后续支持
    //NOTIFICATION、  //后续支持
    //FILE、 //文件消息  //后续支持
    //其他类型不支持，直接置为不识别类型
    private String msgType;
    //服务端生成的消息id，可转为Long型数据
    private String msgidServer;

    public String getConvType() {
        return convType;
    }

    public void setConvType(String convType) {
        this.convType = convType;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getMsgTimestamp() {
        return msgTimestamp;
    }

    public void setMsgTimestamp(String msgTimestamp) {
        this.msgTimestamp = msgTimestamp;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgidServer() {
        return msgidServer;
    }

    public void setMsgidServer(String msgidServer) {
        this.msgidServer = msgidServer;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getFromId() {
        return null;
    }

    @Override
    public String getToId() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public String getRobotId() {
        return null;
    }
}
