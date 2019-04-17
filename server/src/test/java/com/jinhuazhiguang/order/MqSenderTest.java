package com.jinhuazhiguang.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Desc : 发生mq消息测试
 * @auth : pdp
 * @date : 2019/04/12 13:23
 */
@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend("myOrder","computer", "now " + new Date());
    }
}
