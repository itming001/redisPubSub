package com.li.redispubsub.config;

import com.li.redispubsub.service.impl.ListenerServiceImpl;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * redis相关文件
 * @author lym
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        ChannelTopic channelTopic = new ChannelTopic("hello");
        //监听容器绑定需要监听的topic
        container.addMessageListener(listenerAdapter,channelTopic);
        return container;
    }
    /**
     * 初始化对应的监听器，监听器绑定上对应的类信息的某个方法
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(){
        return new MessageListenerAdapter(new ListenerServiceImpl(),"handleMessage");
    }
}
