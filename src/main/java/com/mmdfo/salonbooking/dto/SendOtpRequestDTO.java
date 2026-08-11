package com.mmdfo.salonbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendOtpRequestDTO {

    @NotBlank(message = "Phone number should not be blank!")
    @Pattern(
            regexp = "^9\\d{9}$",
            message = "Invalid phone number format!"
    )
    private String phoneNumber;
}