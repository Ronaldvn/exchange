package com.desafio.exchange.repository;

import com.desafio.exchange.entity.Exchange;
import com.desafio.exchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
