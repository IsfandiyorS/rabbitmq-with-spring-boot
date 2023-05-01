package com.rabbitmq.learn.producer;

import com.rabbitmq.learn.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.jsonRouting.key}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info("Producer sent message: {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void sendJSONMessage(UserDto userDto){
        log.info("User info {}", userDto.toString());
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, userDto);
    }
}
