package com.mmdfo.salonbooking.dto;

import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO extends BaseResponseDTO {

    private String fullName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer workExperience;
    @Column(length = 1000)
    private String bio;
}
