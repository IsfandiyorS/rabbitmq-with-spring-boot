package com.rabbitmq.learn.controller;

import com.rabbitmq.learn.dto.UserDto;
import com.rabbitmq.learn.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody UserDto userDto) {
        rabbitMQProducer.sendJSONMessage(userDto);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
