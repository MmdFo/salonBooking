package com.mmdfo.salonbooking.dto;

import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.enums.Role;
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
public class AdminResponseDTO extends BaseResponseDTO {

    private String fullName;
    private String phoneNumber;
    private String email;
    private AccountStatus accountStatus;
    private Role role;
}