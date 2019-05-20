package com.study.kefu.v1.entity.message.netease.api;

import com.study.kefu.v1.entity.message.AbstractApiMessage;

public class NeteaseApiMessage extends AbstractApiMessage {

    public static final String FORMAT = "netease";

    private String from;
    private String to;
    //消息ID
    private String msgid;
    //消息发送的时间戳
    private long timetag;
    //0 表示文本消息,
    //1 表示图片，
    //2 表示语音，
    //3 表示视频，
    //4 表示地理位置信息，
    //6 表示文件，
    //100 自定义消息类型
    private String type;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public long getTimetag() {
        return timetag;
    }

    public void setTimetag(long timetag) {
        this.timetag = timetag;
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

    public String getType() {
        return type;
    }

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object createRequestBody() {
        return null;
    }
}
