package com.example.cloudstream.consumersimple;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyCustomSink.class)
public class MessageListener {

    @StreamListener(MyCustomSink.INPUT)
    public void readMessage(String message) {
        System.out.println("New message: " + message);
    }
}
