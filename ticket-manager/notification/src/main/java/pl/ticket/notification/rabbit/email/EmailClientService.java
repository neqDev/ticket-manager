package pl.ticket.notification.rabbit.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailClientService
{
    /*TODO: przerobić na nowy switch*/
    @Value("${email.sender.strategy}")
    private String isFakeProp;
    private final Map<String, EmailSender> senderMap;

    public EmailSender getInstance()
    {
        if(isFakeProp.equals("fakeEmailService"))
            return senderMap.get("fakeEmailService");

        return senderMap.get("simpleMailService");
    }
}
