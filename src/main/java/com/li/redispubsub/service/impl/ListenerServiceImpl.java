package com.li.redispubsub.service.impl;

import com.li.redispubsub.service.ListenerService;

import java.io.Serializable;
import java.util.Map;

public class ListenerServiceImpl implements ListenerService {
    @Override
    public void handleMessage(String message) {
        System.err.println("接收到消息信息String："+message);
    }

    @Override
    public void handleMessage(Map message) {
        System.err.println("接收到消息信息String："+message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.err.println("接收到消息信息String："+message);
    }

    @Override
    public void handleMessage(Serializable message) {
        System.err.println("接收到消息信息String："+message);
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.err.println("接收到消息信息String："+message);
    }
}
