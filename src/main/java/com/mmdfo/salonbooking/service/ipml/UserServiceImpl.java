package com.mmdfo.salonbooking.service.impl;

import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.dto.EmployeeCreateRequestDTO;
import com.mmdfo.salonbooking.dto.EmployeeResponseDTO;
import com.mmdfo.salonbooking.dto.UserDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.enums.Role;
import com.mmdfo.salonbooking.exception.UserNotFoundException;
import com.mmdfo.salonbooking.mapper.UserMapper;
import com.mmdfo.salonbooking.repository.UserRepository;
import com.mmdfo.salonbooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public CustomerResponseDTO findCustomerById(Long id) {

        UserEntity user = userRepository
                .findByIdAndRole(id, Role.CUSTOMER)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Customer with id " + id + " not found"
                        )
                );

        return userMapper.toCustomerResponse(user);
    }

    @Override
    public CustomerResponseDTO createCustomer(
            CustomerCreateRequestDTO customerCreateRequestDTO) {

        UserEntity user = userMapper.toEntity(customerCreateRequestDTO);

        user.setRole(Role.CUSTOMER);
        user.setAccountStatus(AccountStatus.ACTIVE);

        UserEntity savedUser = userRepository.save(user);

        return userMapper.toCustomerResponse(savedUser);
    }

    @Override
    public CustomerResponseDTO updateCustomer(
            CustomerCreateRequestDTO request,
            Long id) {

        UserEntity user = userRepository
                .findByIdAndRole(id, Role.CUSTOMER)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Customer with id " + id + " not found"
                        )
                );

        // TODO: update fields

        return userMapper.toCustomerResponse(user);
    }

    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {

        UserEntity user = userRepository
                .findByIdAndRole(id, Role.EMPLOYEE)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Employee with id " + id + " not found"
                        )
                );

        return userMapper.toEmployeeResponse(user);
    }

    @Override
    public EmployeeResponseDTO createEmployee(
            EmployeeCreateRequestDTO employeeCreateRequestDTO) {

        UserEntity user = userMapper.toEntity(employeeCreateRequestDTO);

        user.setRole(Role.EMPLOYEE);
        user.setAccountStatus(AccountStatus.ACTIVE);

        UserEntity savedUser = userRepository.save(user);

        return userMapper.toEmployeeResponse(savedUser);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            EmployeeCreateRequestDTO request,
            Long id) {

        UserEntity user = userRepository
                .findByIdAndRole(id, Role.EMPLOYEE)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Employee with id " + id + " not found"
                        )
                );

        // TODO: update fields

        return userMapper.toEmployeeResponse(user);
    }

    @Override
    public String delete(Long id, Role role) {

        UserEntity user = userRepository
                .findByIdAndRole(id, role)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User with id " + id + " and role " + role + " not found"
                        )
                );

        userRepository.delete(user);

        return "User with id " + id + " has been deleted";
    }

    @Override
    public Page<CustomerResponseDTO> findAllCustomers(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CustomerResponseDTO> findCustomersByStatus(
            AccountStatus status,
            Pageable pageable) {
        return null;
    }

    @Override
    public Page<EmployeeResponseDTO> findAllEmployees(Pageable pageable) {
        return null;
    }

    @Override
    public Page<EmployeeResponseDTO> findEmployeesByStatus(
            AccountStatus status,
            Pageable pageable) {
        return null;
    }

    @Override
    public UserDTO findUserByPhone(String phoneNumber) {

        UserEntity user = userRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User with phone number " + phoneNumber + " not found"
                        )
                );

        return userMapper.toUserDTO(user);
    }
}