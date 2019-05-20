package com.study.kefu.v1.entity.message.standard;

import com.study.kefu.v1.entity.message.Message;

public class StandardMessage<B> implements Message {
    public static final String FORMAT = "standard";

    /**消息ID*/
    private long id;
    //发送方ID
    private String fromId;
    //接收方ID
    private String toId;
    //消息类型
    private String type;
    //消息体，由子类自定义格式
    private B body;
    //时间戳
    private long timestamp;
    //消息平台：小程序，公众号，云信
    private String platform;
    //原消息ID
    private String msgId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
