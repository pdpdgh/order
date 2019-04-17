package com.jinhuazhiguang.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Desc : 接收mq消息
 * @auth : pdp
 * @date : 2019/04/12 13:12
 */
@Slf4j
@Component
public class MqReceiver {

    /** 1. 需要手动创建队列 */
//    @RabbitListener(queues = "myQueue")
    /** 2. 自动创建队列 */
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    /** 3. 自动创建，Exchage和Queue绑定 */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
    * @Desc : 数码供应商服务 接收消息
    */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("computer MqReceiver: {}", message);
    }

    /**
     * @Desc : 水果供应商服务 接收消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver: {}", message);
    }
}
