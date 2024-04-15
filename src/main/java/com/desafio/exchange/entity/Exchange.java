package com.desafio.exchange.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "exchanges")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exchange extends BaseEntity{
    private String originCurrency;
    private String fateCurrency;
    private Double amount;
    private Double exchangeRate;
    private Double amountWithExchange;
}
