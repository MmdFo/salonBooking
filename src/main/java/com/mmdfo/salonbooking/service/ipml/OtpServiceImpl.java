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

    private final StringRedisTemplate redisTemplate;

    @Override
    public void saveOtp(String phoneNumber, String otp) {

        String key = OTP_PREFIX + phoneNumber;

        redisTemplate.opsForValue()
                .set(key, otp, OTP_EXPIRATION);
    }

    @Override
    public String getOtp(String phoneNumber) {

        String key = OTP_PREFIX + phoneNumber;

        return redisTemplate.opsForValue()
                .get(key);
    }

    @Override
    public void deleteOtp(String phoneNumber) {

        String key = OTP_PREFIX + phoneNumber;

        redisTemplate.delete(key);
    }

    public String generateOtp() {

        return String.format(
                "%06d",
                ThreadLocalRandom.current().nextInt(1_000_000)
        );
    }
}