package com.jinhuazhiguang.order.message;

import com.jinhuazhiguang.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Desc : StreamReceiver
 * @auth : pdp
 * @date : 2019/04/12 15:51
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message) {
//        log.info("StreamReceiver: {}", message);
//    }

    /**
    * @Desc : 接收OrderDTO对象
    */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

    @StreamListener(StreamClient.INPUT2)
    public void process(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}
