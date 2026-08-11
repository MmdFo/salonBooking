package com.mmdfo.salonbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendOtpResponseDTO {

    private String message;
    private Integer expiresIn;
}