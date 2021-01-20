package me.jianghs.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.jianghs.producer.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: Producer
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/20 10:13
 * @version: 1.0
 */
@Component
public class Producer {
    public static final String QUEUE_NAME = "chatbot";

    @Autowired
    private AmqpTemplate rabbitTemplate;



    public void send(User user) {
        System.out.println("Sender:" + user.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.rabbitTemplate.convertAndSend(QUEUE_NAME, jsonStr);
    }
}
