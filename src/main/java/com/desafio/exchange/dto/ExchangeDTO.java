package com.desafio.exchange.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeDTO {
    private Double amount;
    @NotBlank
    private String originCurrency;
    @NotBlank
    private String fateCurrency;
}
