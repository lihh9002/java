package com.study.kefu.v1.entity.message;

public class AbstractReplyMessage implements Message{

    public static final String FORMAT = "reply";

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
}
