package com.mmdfo.salonbooking.service;

import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.enums.EmployeeSalonServiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    CustomerResponseDTO findById(Long id);
    CustomerResponseDTO create(CustomerCreateRequestDTO customerCreateRequestDTO);
    CustomerResponseDTO update(CustomerCreateRequestDTO CustomerCreateRequestDTO,  Long id);
    String delete(Long id);
    Page<CustomerResponseDTO> findAll(Pageable pageable);
    Page<CustomerResponseDTO> findByStatus(EmployeeSalonServiceStatus status, Pageable pageable);

}