package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.repository.UserRepository;
import com.mmdfo.salonbooking.service.AuthService;
import com.mmdfo.salonbooking.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final OtpService otpService;
    @Override
    public SendOtpResponseDTO sendOtp(String phoneNumber) {

        UserEntity user = userRepository
                .findByPhoneNumber(phoneNumber)
                .orElse(null);

        if (user != null && user.getAccountStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Account is not active");
        }

        String otp = generateOtp();

        otpService.saveOtp(phoneNumber, otp);

        // Temporary until SMS provider
        System.out.println("OTP for " + phoneNumber + ": " + otp);

        return new SendOtpResponseDTO(
                "OTP sent successfully",
                120
        );
    }
    private String generateOtp() {

        return String.format(
                "%06d",
                ThreadLocalRandom.current().nextInt(1_000_000)
        );
    }
}