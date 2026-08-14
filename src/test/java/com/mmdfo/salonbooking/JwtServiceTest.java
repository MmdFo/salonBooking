package com.mmdfo.salonbooking;

import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.repository.UserRepository;
import com.mmdfo.salonbooking.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldGenerateAndValidateToken() {

        UserEntity user = userRepository.findAll().stream().findFirst().orElseThrow();

        // Generate
        String token = jwtService.generateToken(user);

        System.out.println("Generated JWT:");
        System.out.println(token);

        // Validate
        boolean valid = jwtService.isTokenValid(token);

        System.out.println("Is token valid?");
        System.out.println(valid);

        // Extract user ID
        String userId = jwtService.extractUserId(token);

        System.out.println("Extracted user ID:");
        System.out.println(userId);
    }

    @Test
    void shouldRejectTamperedToken() {

        UserEntity user = userRepository.findAll().stream().findFirst().orElseThrow();

        String token = jwtService.generateToken(user);

        // Change one character in the token
        String tamperedToken = token.substring(0, token.length() - 1) + "X";

        boolean valid = jwtService.isTokenValid(tamperedToken);

        System.out.println("Is tampered token valid?");
        System.out.println(valid);
    }
}