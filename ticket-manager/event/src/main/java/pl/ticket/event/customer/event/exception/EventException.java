package pl.ticket.event.customer.event.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class EventException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
