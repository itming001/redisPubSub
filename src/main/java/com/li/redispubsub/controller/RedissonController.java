package com.li.redispubsub.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试redisson对应controller
 *
 * @author lym
 */
@RestController
public class RedissonController {
    /**
     * 分布式锁对象
     */
    @Resource
    private RedissonClient redissonClient;
    /**
     * 测试计数
     */
    private int count ;

    /**
     * 测试分布式锁信息
     */
    @GetMapping("/testRedisson")
    public void testRedisson() {
        RLock lock = redissonClient.getLock("anyLock");
        lock.lock();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count++);
        lock.unlock();
    }
}
