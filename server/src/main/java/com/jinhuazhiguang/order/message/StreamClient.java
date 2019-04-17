package com.jinhuazhiguang.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Desc : StreamClient
 * @auth : pdp
 * @date : 2019/04/12 15:47
 */
public interface StreamClient {

    String INPUT = "myMessageInput";
    String OUTPUT = "myMessageOutput";

    String INPUT2 = "myMessageInput2";
    String OUTPUT2 = "myMessageOutput2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();
}
