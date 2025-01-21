package pl.ticket.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "pl.ticket.customer",
                "pl.ticket.amqp"
        }
)
@EnableFeignClients(
                basePackages = "pl.ticket.feign"
        )
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class);
    }
}