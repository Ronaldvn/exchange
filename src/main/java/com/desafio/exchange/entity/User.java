package com.desafio.exchange.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        })
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity{
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
