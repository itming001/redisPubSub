package com.li.redispubsub.service;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息监听方法接口
 * @author lym
 */
public interface ListenerService {
    /**
     * 处理消息
     * @param message
     */
    void handleMessage(String message);

    /**
     * 处理消息
     * @param message
     */
    void handleMessage(Map message);

    /**
     * 处理消息
     * @param message
     */
    void handleMessage(byte[] message);

    /**
     * 处理消息
     * @param message
     */
    void handleMessage(Serializable message);

    /**
     * 处理消息
     * @param message
     * @param channel
     */
    void handleMessage(Serializable message, String channel);
}
