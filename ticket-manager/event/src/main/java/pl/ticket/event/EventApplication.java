package pl.ticket.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication(

        scanBasePackages = {
                "pl.ticket.event",
                "pl.ticket.amqp",
                "pl.ticket.feign"
        }
)
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }
}
