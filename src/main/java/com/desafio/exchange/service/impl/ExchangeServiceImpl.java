package com.desafio.exchange.service.impl;

import com.desafio.exchange.client.RateFeignClient;
import com.desafio.exchange.dto.ExchangeDTO;
import com.desafio.exchange.dto.RateDTO;
import com.desafio.exchange.entity.Exchange;
import com.desafio.exchange.repository.ExchangeRepository;
import com.desafio.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final RateFeignClient client;
    private final ExchangeRepository exchangeRepository;
    @Override
    public Exchange save(ExchangeDTO exchangeDTO) {
        RateDTO rateDTO = client.getRate(exchangeDTO.getOriginCurrency());
        if (Objects.isNull(rateDTO.getRates())){
            return null;
        }
        if (!rateDTO.getRates().containsKey(exchangeDTO.getFateCurrency())){
            return null;
        }
        Double exchangeRate = rateDTO.getRates().get(exchangeDTO.getFateCurrency());
        Double amountWithExchange = exchangeDTO.getAmount() * exchangeRate;

        Exchange exchange = Exchange.builder()
                .amount(exchangeDTO.getAmount())
                .originCurrency(exchangeDTO.getOriginCurrency())
                .fateCurrency(exchangeDTO.getFateCurrency())
                .exchangeRate(exchangeRate)
                .amountWithExchange(amountWithExchange)
                .build();

        return exchangeRepository.save(exchange);
    }

    @Override
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }
}
