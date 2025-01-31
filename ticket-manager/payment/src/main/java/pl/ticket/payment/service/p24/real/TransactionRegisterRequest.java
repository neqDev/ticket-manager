package pl.ticket.payment.service.p24.real;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionRegisterRequest {
    private Integer merchantId;
    private Integer posId;
    private String sessionId;
    private Integer amount;
    private String currency;
    private String description;
    private String email;
    private String client;
    private String country;
    private String language;
    private String urlReturn;
    private String sign;
    private String encoding; // jesli przesylamy polskie znaki
}
