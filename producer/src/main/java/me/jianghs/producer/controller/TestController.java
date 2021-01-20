package me.jianghs.producer.controller;

import me.jianghs.producer.Producer;
import me.jianghs.producer.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/20 10:57
 * @version: 1.0
 */
@RestController
public class TestController {
    @Autowired
    private Producer producer;

    @RequestMapping("/mq-test")
    public String test(@RequestBody User user) {
        producer.send(user);
        return "发送成功";
    }
}
