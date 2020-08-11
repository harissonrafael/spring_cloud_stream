package com.example.cloudstream.consumersimple;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyCustomSink {
    String INPUT = "input";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();
}
