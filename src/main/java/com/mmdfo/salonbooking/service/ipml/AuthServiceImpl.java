package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;
import com.mmdfo.salonbooking.dto.VerifyOtpRequestDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.repository.UserRepository;
import com.mmdfo.salonbooking.service.AuthService;
import com.mmdfo.salonbooking.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO) {

        String storedOtp = otpService.getOtp(verifyOtpRequestDTO.getPhoneNumber());

        if (storedOtp == null) {
            throw new IllegalStateException("OTP not found");
        }

        if (!storedOtp.equals(verifyOtpRequestDTO.getOtp())) {
            throw new IllegalStateException("Invalid OTP");
        }
        otpService.deleteOtp(
                verifyOtpRequestDTO.getPhoneNumber()
        );
    }
}