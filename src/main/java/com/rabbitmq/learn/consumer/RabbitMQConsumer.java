package com.rabbitmq.learn.consumer;

import com.rabbitmq.learn.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receivedMessage(String message) {
        log.info("Consumer received message {}", message);
    }

    @RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
    public void receivedMessage(UserDto user){
        log.info("User info {}", user.toString());
    }

}