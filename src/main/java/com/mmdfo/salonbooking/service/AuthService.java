package com.mmdfo.salonbooking.service;

import com.mmdfo.salonbooking.dto.SendOtpResponseDTO;

public interface AuthService{

    SendOtpResponseDTO sendOtp(String phoneNumber);
}
