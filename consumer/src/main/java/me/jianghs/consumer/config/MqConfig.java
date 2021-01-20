package me.jianghs.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MqConfig
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/20 10:12
 * @version: 1.0
 */
@Configuration
public class MqConfig {
    public static final String QUEUE_NAME = "chatbot";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME);
    }
}
