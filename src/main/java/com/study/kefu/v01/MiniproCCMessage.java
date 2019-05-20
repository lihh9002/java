package com.study.kefu.v01;

import com.study.kefu.v1.entity.message.AbstractCCMessage;

/**
 * 小程序抄送消息
 */
public class MiniproCCMessage extends AbstractCCMessage {

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
