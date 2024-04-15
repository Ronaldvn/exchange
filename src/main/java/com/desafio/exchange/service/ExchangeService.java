package com.desafio.exchange.service;

import com.desafio.exchange.dto.ExchangeDTO;
import com.desafio.exchange.entity.Exchange;

import java.util.List;

public interface ExchangeService
{
    public Exchange save(ExchangeDTO exchangeDTO);
    public List<Exchange> findAll();
}
