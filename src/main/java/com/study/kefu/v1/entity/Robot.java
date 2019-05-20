package com.study.kefu.v1.entity;

import java.util.Objects;

/**
 * 机器人信息
 */
public class Robot {

    public static final String PLATFORM_MINIPRO = "minipro";
    public static final String PLATFORM_PUBLIC = "public";
    public static final String PLATFORM_NETEASE = "netease";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(robotId, robot.robotId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(robotId);
    }
}
