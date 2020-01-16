package com.david.eureka;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    @Autowired
    EmailService emailService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(UserDto payload) {
        emailService.sendSimpleMessage(payload);
        latch.countDown();
    }

}
