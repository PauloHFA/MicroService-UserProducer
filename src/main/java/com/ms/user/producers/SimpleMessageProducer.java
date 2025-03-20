package com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.simple}")
    private String simpleRoutingKey;

    public SimpleMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishSimpleMessage(String text) {
        rabbitTemplate.convertAndSend("", simpleRoutingKey, text);
        System.out.println("Mensagem simples publicada: " + text);
    }
}
