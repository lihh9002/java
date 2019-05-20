package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.CustomerServiceDTO;
import com.study.kefu.v1.entity.Robot;

//此处可扩展
public class CustomerServiceService {

    public CustomerServiceDTO getCustomerService(Robot serviceRobot){
        return new CustomerServiceDTO();
    }
}
