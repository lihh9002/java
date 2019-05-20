package com.study.kefu.v01;

import com.study.kefu.v1.entity.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 机器人消息
 */
public abstract class RobotMessage implements Message {
    private final static Logger logger = LoggerFactory.getLogger(RobotMessage.class);

    public String getUserId(){
        return getFromId();
    }

    public String getRobotId(){
        return getToId();
    }
}
