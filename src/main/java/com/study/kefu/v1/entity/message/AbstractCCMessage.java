package com.study.kefu.v1.entity.message;

/**
 * 抄送消息基类，保存原始消息内容
 */
public abstract class AbstractCCMessage implements Message {
    private String originMsg;

    public String getOriginMsg() {
        return originMsg;
    }

    public void setOriginMsg(String originMsg) {
        this.originMsg = originMsg;
    }
}
