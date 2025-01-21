package pl.ticket.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMqMessageProducer
{
    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey)
    {
        log.info("publishing to {} using key {}. service: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("published to {} using key {}. service: {}", exchange, routingKey, payload);
    }
}
