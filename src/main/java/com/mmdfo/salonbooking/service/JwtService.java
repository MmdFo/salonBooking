package com.mmdfo.salonbooking.service;

import com.mmdfo.salonbooking.entity.UserEntity;

public interface JwtService {

    String generateToken(UserEntity user);

    String extractUserId(String token);

    boolean isTokenValid(String token);
}
