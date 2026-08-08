package com.mmdfo.salonbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDTO {
        private Long id;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
