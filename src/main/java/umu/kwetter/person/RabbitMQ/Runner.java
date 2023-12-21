package umu.kwetter.person.RabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Long id) {
        System.out.println("Sending data...");
        rabbitTemplate.convertAndSend(Config.topicExchangeName, "msg", id);
    }

}
