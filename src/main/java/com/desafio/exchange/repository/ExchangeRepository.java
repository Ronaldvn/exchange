package com.desafio.exchange.repository;

import com.desafio.exchange.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
}
