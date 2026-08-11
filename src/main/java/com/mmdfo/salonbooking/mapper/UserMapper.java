package com.mmdfo.salonbooking.mapper;

import com.mmdfo.salonbooking.dto.AdminCreateRequestDTO;
import com.mmdfo.salonbooking.dto.AdminResponseDTO;
import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.dto.EmployeeCreateRequestDTO;
import com.mmdfo.salonbooking.dto.EmployeeResponseDTO;
import com.mmdfo.salonbooking.dto.UserDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(CustomerCreateRequestDTO dto);

    UserEntity toEntity(EmployeeCreateRequestDTO dto);

    UserEntity toEntity(AdminCreateRequestDTO dto);

    CustomerResponseDTO toCustomerResponse(UserEntity entity);

    EmployeeResponseDTO toEmployeeResponse(UserEntity entity);

    AdminResponseDTO toAdminResponse(UserEntity entity);

    UserDTO toUserDTO(UserEntity entity);
}