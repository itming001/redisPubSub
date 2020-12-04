package com.li.redispubsub.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * 分布式锁对应的配置文件
 * @author lym
 */
@Configuration
public class RedissonConfig {
    /**
     * 分布式锁对应的配置文件信息
     * @return
     */
    @Bean
    public Config config(){
        Config config = new Config();
        //配置redis对应的地址信息
        config.useSingleServer()
                // use "rediss://" for SSL connection
                .setAddress("redis://127.0.0.1:6379");
        return config;
    }

    /**
     * 创建redis分布式锁对应的实例信息
     * @param config
     * @return
     */
    @Bean
    public RedissonClient redissonClient(Config config){
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
