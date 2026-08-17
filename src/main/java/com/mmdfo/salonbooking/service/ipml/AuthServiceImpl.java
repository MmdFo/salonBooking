package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.dto.AuthResponseDTO;
import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;
import com.mmdfo.salonbooking.dto.VerifyOtpRequestDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.repository.UserRepository;
import com.mmdfo.salonbooking.service.AuthService;
import com.mmdfo.salonbooking.service.JwtService;
import com.mmdfo.salonbooking.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final OtpService otpService;
    private final JwtService jwtService;

    @Override
    public SendOtpResponseDTO sendOtp(String phoneNumber) {

        UserEntity user = userRepository
                .findByPhoneNumber(phoneNumber)
                .orElse(null);

        if (user != null && user.getAccountStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Account is not active");
        }

        String otp = otpService.generateOtp();

        otpService.saveOtp(phoneNumber, otp);

        // Temporary until SMS provider
        System.out.println("OTP for " + phoneNumber + ": " + otp);

        return new SendOtpResponseDTO(
                "OTP sent successfully",
                120
        );
    }

    @Override
    public AuthResponseDTO verifyOtp(
            VerifyOtpRequestDTO verifyOtpRequestDTO
    ) {

        String phoneNumber = verifyOtpRequestDTO.getPhoneNumber();

        String storedOtp = otpService.getOtp(phoneNumber);

        if (storedOtp == null) {
            throw new IllegalStateException("OTP expired or not found");
        }

        if (!storedOtp.equals(verifyOtpRequestDTO.getOtp())) {
            throw new IllegalStateException("Invalid OTP");
        }

        otpService.deleteOtp(phoneNumber);

        UserEntity user = userRepository.findByPhoneNumber(phoneNumber).orElse(null);

        if (user == null){

            String registrationToken = UUID.randomUUID().toString();
            otpService.saveRegistrationToken(phoneNumber, registrationToken);
            return new AuthResponseDTO(null, null, true,  registrationToken);
        }

        String token = jwtService.generateToken(user);

        // Return authentication response
        return new AuthResponseDTO(token, "Bearer", false, null);
    }
}