package com.desafio.exchange.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtDTO {
    private String token;
    private final String type = "Bearer";
    private Long id;
    private String username;

    public JwtDTO(String accessToken, Long id, String username) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
    }
}
