package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private static final Duration OTP_EXPIRATION = Duration.ofMinutes(2);
    private static final String OTP_PREFIX = "otp:";
    private static final Duration REGISTRATION_EXPIRATION = Duration.ofMinutes(10);
    private static final String REGISTRATION_TOKEN_PREFIX = "registration:";

    private final StringRedisTemplate redisTemplate;

    @Override
    public void saveOtp(String phoneNumber, String otp) {

        String key = OTP_PREFIX + phoneNumber;

        System.out.println(">>> SAVE OTP KEY: [" + key + "]");
        System.out.println(">>> SAVE OTP VALUE: [" + otp + "]");

        redisTemplate.opsForValue()
                .set(key, otp, OTP_EXPIRATION);

        System.out.println(">>> OTP SAVED SUCCESSFULLY");
    }

    @Override
    public String getOtp(String phoneNumber) {

        String key = OTP_PREFIX + phoneNumber;

        System.out.println(">>> GET OTP KEY: [" + key + "]");

        String otp = redisTemplate.opsForValue()
                .get(key);

        System.out.println(">>> GET OTP RESULT: [" + otp + "]");

        return otp;
    }

    @Override
    public void deleteOtp(String phoneNumber) {

        String key = OTP_PREFIX + phoneNumber;

        System.out.println(">>> DELETE OTP KEY: [" + key + "]");

        Boolean deleted = redisTemplate.delete(key);

        System.out.println(">>> OTP DELETED: [" + deleted + "]");
    }

    @Override
    public String generateOtp() {

        String otp = String.format(
                "%06d",
                ThreadLocalRandom.current().nextInt(1_000_000)
        );

        System.out.println(">>> GENERATED OTP: [" + otp + "]");

        return otp;
    }
    @Override
    public void saveRegistrationToken(String token, String phoneNumber) {

        String key = REGISTRATION_TOKEN_PREFIX + token;

        redisTemplate.opsForValue()
                .set(key, phoneNumber, REGISTRATION_EXPIRATION);
    }

    @Override
    public String getRegistrationPhone(String token) {

        String key = REGISTRATION_TOKEN_PREFIX + token;

        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void deleteRegistrationToken(String token) {

        String key = REGISTRATION_TOKEN_PREFIX + token;

        redisTemplate.delete(key);
    }
}