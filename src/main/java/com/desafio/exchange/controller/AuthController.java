package com.desafio.exchange.controller;

import com.desafio.exchange.dto.LoginDTO;
import com.desafio.exchange.dto.SignupDTO;
import com.desafio.exchange.dto.JwtDTO;
import com.desafio.exchange.entity.User;
import com.desafio.exchange.repository.UserRepository;
import com.desafio.exchange.security.jwt.JwtUtils;
import com.desafio.exchange.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtDTO(jwt,
                userDetails.getId(),
                userDetails.getUsername()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO signUpRequest) {

        if (!userRepository.existsByUsername(signUpRequest.getUsername())){
            User user = User.builder().username(signUpRequest.getUsername())
                    .password(encoder.encode(signUpRequest.getPassword())).build();
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.badRequest().build();

    }
}
