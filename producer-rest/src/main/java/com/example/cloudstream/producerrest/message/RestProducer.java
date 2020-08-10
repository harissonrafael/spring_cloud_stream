package com.example.cloudstream.producerrest.message;

import com.example.cloudstream.producerrest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestProducer {

    @Autowired
    private RestSource restSource;

    public boolean sendMessageProduct(Product payload) {
        Message<Product> message = MessageBuilder.withPayload(payload).build();
        return restSource.sendMessage().send(message);
    }
}
