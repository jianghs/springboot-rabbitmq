package me.jianghs.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import me.jianghs.consumer.dto.UserDTO;
/**
 * @className: Consumer
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/20 10:13
 * @version: 1.0
 */
@Component
public class Consumer {
    @RabbitHandler
    @RabbitListener(queues = "chatbot")
    public void process(String msg) {
        ObjectMapper objectMapper = new ObjectMapper();
        //json字符串转成Java对象
        UserDTO userDTO = null;
        try {
            userDTO = objectMapper.readValue(msg , UserDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver:" + userDTO.toString());
    }
}
