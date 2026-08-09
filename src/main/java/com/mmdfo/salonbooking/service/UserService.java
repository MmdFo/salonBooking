package com.mmdfo.salonbooking.service;

import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.dto.EmployeeCreateRequestDTO;
import com.mmdfo.salonbooking.dto.EmployeeResponseDTO;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    CustomerResponseDTO findCustomerById(Long id);

    CustomerResponseDTO createCustomer(CustomerCreateRequestDTO customerCreateRequestDTO);

    CustomerResponseDTO updateCustomer(CustomerCreateRequestDTO CustomerCreateRequestDTO, Long id);

    EmployeeResponseDTO findEmployeeById(Long id);

    EmployeeResponseDTO createEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO);

    EmployeeResponseDTO updateEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO, Long id);

    String delete(Long id);

    Page<CustomerResponseDTO> findAllCustomers(Pageable pageable, Role role);

    Page<CustomerResponseDTO> findCustomersByStatus(AccountStatus status, Pageable pageable);

    Page<EmployeeResponseDTO> findAllEmployees(Pageable pageable, Role role);

    Page<EmployeeResponseDTO> findEmployeesByStatus(AccountStatus status, Pageable pageable);

}