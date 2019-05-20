package com.study.kefu.v1.service;

import com.study.kefu.v1.entity.MessageSession;
import com.study.kefu.v1.entity.Robot;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageSessionService {

    private RobotInfoService robotInfoService = new RobotInfoService();
    private CustomerServiceService customerServiceService = new CustomerServiceService();

    /**
     * 查询会话，如果不存在，则创建新的会话
     * todo: 此处可以做会话的缓存
     * todo: 此方法对userId上锁，避免产生多个会话
     * @return
     */
    public MessageSession getSession(String userId, String userRobot){
        //查询客服机器人
        Robot serviceRobot = robotInfoService.getServiceRobot(userRobot);
        // TODO: 2019/5/18 根据userId查询全部会话
        List<MessageSession> sessions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sessions)){
            return createSession(userId, userRobot, serviceRobot);
        }
        //循环遍历所有的会话，检查是否有正常的会话
        MessageSession lastSession = null;
        for (MessageSession ms : sessions) {
            //1表示正常，而且是和指定的机器人
            if (ms.getStatus() == 1 && ms.getServiceRobot().equals(serviceRobot)){
                lastSession = ms;
                break;
            }
        }
        //查询用户在当前用户机器人是否有会话
        if (lastSession.getUserRobot().equals(userRobot)){
            return lastSession;
        }
        //否则，copy原会话信息的分配的客服信息，创建新的会话
        MessageSession session = copyServiceSession(lastSession);
        //设置新的机器人
        session.setUserRobot(robotInfoService.getRobot(userRobot));
        this.saveSession(session);
        //更新原会话为暂停
        this.updateStatus(lastSession, -1);
        return session;
    }

    /**
     * 切换客服
     * @param sessionId
     * @param newServiceId
     */
    public String switchService(String sessionId, String newServiceId){
        MessageSession session = this.getBySessionId(sessionId);
        MessageSession newSession = this.copyUserSession(session);
        newSession.setServiceId(newServiceId);
        newSession.setServiceRobot(session.getServiceRobot());
        this.saveSession(newSession);
        //原会话置为切换状态
        session.setStatus(-2);
        this.saveSession(session);
        return newSession.getSessionId();
    }

    /**
     * 切换客服机器人
     * @param sessionId
     * @param serviceRobot
     * @return
     */
    public MessageSession switchServiceRobot(String sessionId, Robot serviceRobot){
        MessageSession session = this.getBySessionId(sessionId);
        MessageSession newSession = this.copyUserSession(session);
        newSession.setServiceRobot(serviceRobot);
        return newSession;
    }

    /**
     * 更新状态
     * @param session
     * @param status
     */
    private void updateStatus(MessageSession session, int status){
        session.setStatus(status);
        this.saveSession(session);
    }

    /**
     * 创建新会话
     * @param userId
     * @param userRobot
     * @param serviceRobot
     * @return
     */
    private MessageSession createSession(String userId, String userRobot, Robot serviceRobot){
        MessageSession session = new MessageSession();
        session.setSessionId(this.generateSessionId());
        session.setUserId(userId);
        session.setUserRobot(robotInfoService.getRobot(userRobot));
        session.setServiceRobot(serviceRobot);
        session.setServiceId(customerServiceService.getCustomerService(serviceRobot).getId());
        session.setStatus(1);//正常
        session.setVersion(0);//初始版本
        this.saveSession(session);
        return session;
    }

    /**
     * 用户的变更，复制客服信息，创建新的会话
     * @param lastSession
     * @return
     */
    private MessageSession copyServiceSession(MessageSession lastSession){
        MessageSession session = new MessageSession();
        session.setSessionId(this.generateSessionId());
        session.setServiceRobot(lastSession.getServiceRobot());
        session.setServiceId(lastSession.getServiceId());
        session.setStatus(lastSession.getStatus());//正常
        session.setVersion(lastSession.getVersion());
        session.setUserId(lastSession.getUserId());
        return session;
    }

    /**
     * 客服的变更，复制用户信息，创建信息的会话，会话版本递增
     * @param ms
     * @return
     */
    private MessageSession copyUserSession(MessageSession ms){
        MessageSession session = new MessageSession();
        session.setSessionId(this.generateSessionId());
        session.setServiceRobot(ms.getServiceRobot());
        session.setStatus(1);//正常
        session.setVersion(ms.getVersion() + 1);
        session.setUserId(ms.getUserId());
        return session;
    }

    /**
     * 保存会话信息
     * @param session
     */
    private void saveSession(MessageSession session){
        // TODO: 2019/5/18 保存数据库，缓存等
    }

    /**
     * 根据SessionId查询会话
     * @param sessionId
     * @return
     */
    private MessageSession getBySessionId(String sessionId){
        return new MessageSession();
    }

    /**
     * 会话ID生成策略
     * @return
     */
    private String generateSessionId(){
        return UUID.randomUUID().toString();
    }
}
