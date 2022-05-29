package com.personal.rabbitmqdemo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.personal.rabbitmqdemo.constants.CommonConstants.DK_QUEUE;
import static com.personal.rabbitmqdemo.constants.CommonConstants.DK_QUEUE2;

@Component
public class Consumer {
    @RabbitListener(queues = {DK_QUEUE, DK_QUEUE2})
    public void consume(String msg) {
        System.out.println("received message : " + msg);
    }
}
