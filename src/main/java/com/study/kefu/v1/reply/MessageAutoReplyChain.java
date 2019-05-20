package com.study.kefu.v1.reply;

import com.study.kefu.v1.entity.message.Message;
import com.study.kefu.v1.entity.message.standard.StandardMessage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageAutoReplyChain {

    private List<MessageAutoReplyHandler> handlers = new ArrayList<>();

    public List<StandardMessage> autoReply(Message message, String platform){
        List<StandardMessage> replyMsgs = new LinkedList<>();
        for (MessageAutoReplyHandler handler : handlers) {
            StandardMessage replyMsg = handler.autoReply(message, platform);
            if (replyMsg != null){
                replyMsgs.add(replyMsg);
            }
        }
        return replyMsgs;
    }
}
