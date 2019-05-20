package com.study.kefu.v01;

import com.study.kefu.v1.entity.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 机器人消息
 */
public abstract class RobotMessage implements Message {
    private final static Logger logger = LoggerFactory.getLogger(RobotMessage.class);

    @Override
    public String getFromId() {
        logger.warn("不建议直接调用该方法，请调用getUserId");
        return super.getFromId();
    }

    @Override
    public String getToId() {
        logger.warn("不建议直接调用该方法，请调用getRobotId");
        return super.getToId();
    }

    public String getUserId(){
        return super.getFromId();
    }

    public String getRobotId(){
        return super.getToId();
    }
}
