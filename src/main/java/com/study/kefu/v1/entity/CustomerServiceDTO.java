package com.study.kefu.v1.entity;

/**
 * 客服信息
 */
public class CustomerServiceDTO {
    //客服ID
    private String id;
    //状态（在线：1，离线：-1）
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
