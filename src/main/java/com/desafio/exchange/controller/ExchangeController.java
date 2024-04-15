package com.desafio.exchange.controller;

import com.desafio.exchange.dto.ExchangeDTO;
import com.desafio.exchange.entity.Exchange;
import com.desafio.exchange.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<List<Exchange>> findAll(){
        return ResponseEntity.ok(exchangeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Exchange> save(@Valid @RequestBody ExchangeDTO exchangeDTO){
        Exchange exchange = exchangeService.save(exchangeDTO);
        if (!Objects.isNull(exchange)){
            return ResponseEntity.ok(exchange);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
