package com.example.cloudstream.producersimple.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@EnableBinding(Source.class)
public class MySimpleProducer {

    private String defaultMessage = "Hello, Spring Cloud Stream";

    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000"))
    public String sendDefaultMessage() {
        System.out.println(defaultMessage);
        return defaultMessage;
    }

}
