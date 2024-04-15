package com.desafio.exchange.client;

import com.desafio.exchange.configuration.FeignClientConfig;
import com.desafio.exchange.dto.RateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATE-API", url = "${external.api.base-url}", configuration = FeignClientConfig.class)
public interface RateFeignClient {

    @GetMapping(value = "/{currency}", consumes = MediaType.APPLICATION_JSON_VALUE)
    RateDTO getRate(@PathVariable(value = "currency") String currency);
}
