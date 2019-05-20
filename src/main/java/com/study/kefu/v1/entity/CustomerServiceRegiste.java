package com.study.kefu.v1.entity;

import java.util.Date;

/**
 * 客服注册信息
 */
public class CustomerServiceRegiste {
    //客服ID
    private String userName;
    //注册密码
    private String password;
    //机器人ID
    private String robotId;
    //注册时间
    private Date registerDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
