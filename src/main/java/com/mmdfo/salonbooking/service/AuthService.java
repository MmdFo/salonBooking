package com.mmdfo.salonbooking.service;

import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;
import com.mmdfo.salonbooking.dto.VerifyOtpRequestDTO;

public interface AuthService {

    SendOtpResponseDTO sendOtp(String phoneNumber);

    void verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO);
}
