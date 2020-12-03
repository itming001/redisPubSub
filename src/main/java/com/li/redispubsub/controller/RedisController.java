package com.li.redispubsub.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lym
 */
@RestController
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 发送redis消息
     */
    @GetMapping("/testRedis")
    public void testRedis(){
        redisTemplate.opsForValue().set("student:name","张三");
        //发送数据信息
        redisTemplate.convertAndSend("hello","world!");

    }
}
