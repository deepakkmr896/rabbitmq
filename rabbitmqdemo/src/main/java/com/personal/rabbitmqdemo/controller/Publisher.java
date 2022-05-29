package com.personal.rabbitmqdemo.controller;

import lombok.CustomLog;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.personal.rabbitmqdemo.constants.CommonConstants.DK_FANOUT_EXCHANGE;

@RestController
@Log4j2
public class Publisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public void publish() {
        template.convertAndSend(DK_FANOUT_EXCHANGE, "", "hello!");
        log.info("published");
    }
}
