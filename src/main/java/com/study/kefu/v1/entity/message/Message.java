package com.study.kefu.v1.entity.message;

public interface Message {

    long getId();

    String getFromId();

    String getToId();

    String getType();

    Object getBody();

    long getTimestamp();
}
