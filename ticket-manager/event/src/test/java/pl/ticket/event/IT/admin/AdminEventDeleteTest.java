package pl.ticket.event.IT.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ticket.event.admin.event.repository.AdminEventRepository;
import pl.ticket.event.admin.event.service.AdminEventService;
import pl.ticket.event.admin.event_occurrence.repository.AdminEventOccurrenceRepository;
import pl.ticket.event.IT.PrePost;
import pl.ticket.event.admin.ticket.repository.AdminTicketRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminEventDeleteTest extends PrePost
{

    @Autowired
    private AdminEventService adminEventService;

    @Autowired
    private AdminEventRepository adminEventRepository;

    @Autowired
    private AdminEventOccurrenceRepository eventOccurrenceRepository;

    @Autowired
    private AdminTicketRepository adminTicketRepository;

    @Test
    public void shouldDeleteEventWithOccurrencesAndTickets()
    {

        adminEventService.deleteEventById(111L);


        long countedEventsAfter = adminEventRepository.count();
        long countedOccurrencesAfter = eventOccurrenceRepository.count();
        long countedTicketsAfter = adminTicketRepository.count();

        assertEquals(1, countedEventsAfter , "Unexpected event count after creation");
        assertEquals(1, countedOccurrencesAfter , "Unexpected occurrences count after creation");
        assertEquals(2, countedTicketsAfter , "Unexpected tickets count after creation");
    }
}
