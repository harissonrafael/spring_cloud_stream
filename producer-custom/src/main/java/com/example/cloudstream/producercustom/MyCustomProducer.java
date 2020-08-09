package com.example.cloudstream.producercustom;

import com.example.cloudstream.producercustom.message.dto.Message;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(MyCustomSource.class)
public class MyCustomProducer {

    private String mySimpleMessage = "This is my simple message";
    private String customMessage = "This is my custom message";

    @Bean
    @InboundChannelAdapter(channel = "default-channel", poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Message> sendMessageDefault() {
        return () -> MessageBuilder.withPayload(new Message(mySimpleMessage)).build();
    }

    @Bean
    @InboundChannelAdapter(channel = "custom-channel", poller = @Poller(fixedDelay = "3000"))
    public MessageSource<Message> sendCustomMessage() {
        return () -> MessageBuilder.withPayload(new Message(customMessage)).build();
    }

}
