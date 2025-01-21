package pl.ticket.event.internal.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;
import pl.ticket.dto.OrderEvent;
import pl.ticket.event.internal.ticket.service.SagaReservationProcessService;

@Component
@Slf4j
@AllArgsConstructor
public class ReservationProcessExceptionHandler implements RabbitListenerErrorHandler
{
    private final SagaReservationProcessService sagaReservationProcessService;
    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException ex) {
        log.error("Error occurred while processing message: {}", ex.getMessage());

        OrderEvent orderEvent = (OrderEvent) message.getPayload();
        orderEvent.setMessage(ex.getCause().getMessage());

        sagaReservationProcessService.publishReservationRejected(orderEvent);
        throw new AmqpRejectAndDontRequeueException(ex.getCause().getMessage());
    }
}
