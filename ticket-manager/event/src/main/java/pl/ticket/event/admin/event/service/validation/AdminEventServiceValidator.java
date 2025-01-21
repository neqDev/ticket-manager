package pl.ticket.event.admin.event.service.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ticket.event.admin.event.dto.AdminEventRegularCreationDto;
import pl.ticket.event.admin.event.dto.EventType;
import pl.ticket.event.admin.event.exception.InvalidRequestedDataException;

import java.time.Clock;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminEventServiceValidator
{
    private final Clock clock;

    public void validateAdminEventRegularCreationDto(AdminEventRegularCreationDto adminEventRegularCreationDto)
    {
        LocalDate now = LocalDate.now(clock);

        log.info(now.toString());

        if (!adminEventRegularCreationDto.getEventType().equals(EventType.REGULAR))
            throw new InvalidRequestedDataException("Zły typ eventu!");

        if(adminEventRegularCreationDto.getStartDate().isBefore(now) || adminEventRegularCreationDto.getEndDate().isBefore(now))
            throw new InvalidRequestedDataException("Nie można stworzyć eventu w podanym zakresie czasowym.");

        if(adminEventRegularCreationDto.getEndDate().isBefore(adminEventRegularCreationDto.getStartDate()))
            throw new InvalidRequestedDataException("Podany został zły zakres czasowy.");
    }
}
