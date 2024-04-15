package com.desafio.exchange.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RateDTO {
    private Map<String, Double> rates;
}
