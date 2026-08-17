package com.mmdfo.salonbooking.service;

public interface OtpService {

    void saveOtp(String phoneNumber, String otp);

    String getOtp(String phoneNumber);

    void deleteOtp(String phoneNumber);

    String generateOtp();

    void saveRegistrationToken(String token, String phoneNumber);

    String getRegistrationPhone(String token);

    void deleteRegistrationToken(String token);
}