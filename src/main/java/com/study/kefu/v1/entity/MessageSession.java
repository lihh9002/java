package com.study.kefu.v1.entity;

public class MessageSession {
    //uuid
    private String sessionId;
    private String userId;
    private String serviceId;
    //1、正常，0、待接，-1、暂停，-2，切换
    private int status;
    //用户机器人
    private Robot userRobot;
    //客服机器人
    private Robot serviceRobot;
    //会话版本，在切换客服时自增
    private int version = 0;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Robot getUserRobot() {
        return userRobot;
    }

    public void setUserRobot(Robot userRobot) {
        this.userRobot = userRobot;
    }

    public Robot getServiceRobot() {
        return serviceRobot;
    }

    public void setServiceRobot(Robot serviceRobot) {
        this.serviceRobot = serviceRobot;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
