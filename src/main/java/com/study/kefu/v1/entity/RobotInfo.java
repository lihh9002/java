package com.study.kefu.v1.entity;

public class RobotInfo {
    //自增ID，从8000开始，用来存储数据的表
    private int id;
    //平台：小程序客服（minipro），公众号(public)，云信(netease)
    private String platform;
    //如果是小程序客服或公众号，则是AppId，如果是云信，则是云信的特殊账户ID
    private String robotId;
    //角色：用户，客服
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
