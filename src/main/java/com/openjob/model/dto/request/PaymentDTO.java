package com.openjob.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
