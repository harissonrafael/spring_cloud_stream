package com.example.cloudstream.consumersimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerSimpleApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void readMessage(String message) {
		System.out.println("New message: " + message);
	}

}
