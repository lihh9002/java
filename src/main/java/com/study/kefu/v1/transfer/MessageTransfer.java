package com.study.kefu.v1.transfer;

import com.study.kefu.v1.entity.message.Message;

public interface MessageTransfer {

    Message transfer(Message sourceMsg, String direction);

}
