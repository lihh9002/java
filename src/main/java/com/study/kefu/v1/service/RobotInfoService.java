package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.Robot;
import com.study.kefu.v1.entity.RobotBind;

public class RobotInfoService {

    private RobotBindService robotBindService = new RobotBindService();

    public Robot getRobot(String robotId){
        Robot robot = new Robot();
        return robot;
    }

    public Robot getServiceRobot(String userRobot){
        RobotBind robotBind = robotBindService.getByUserRobot(userRobot);
        return getRobot(robotBind.getService());
    }

    public Robot getUserRobot(String serviceRobot){
        RobotBind robotBind = robotBindService.getByServiceRobot(serviceRobot);
        return getRobot(robotBind.getUser());
    }
}
