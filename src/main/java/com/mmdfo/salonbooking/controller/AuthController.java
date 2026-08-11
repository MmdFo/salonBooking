package com.mmdfo.salonbooking.controller;

import com.mmdfo.salonbooking.dto.SendOtpRequestDTO;
import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;
import com.mmdfo.salonbooking.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/send-otp")
    public ResponseEntity<SendOtpResponseDTO> sendOtp(
            @Valid @RequestBody SendOtpRequestDTO request) {

        return ResponseEntity.ok(
                authService.sendOtp(request.getPhoneNumber())
        );
    }
}