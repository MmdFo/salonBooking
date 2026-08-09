package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.dto.EmployeeCreateRequestDTO;
import com.mmdfo.salonbooking.dto.EmployeeResponseDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.AccountStatus;
import com.mmdfo.salonbooking.enums.Role;
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
        UserEntity response = userRepository.findById(id).orElseThrow();
        return userMapper.toCustomerResponse(response);
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerCreateRequestDTO customerCreateRequestDTO) {
        UserEntity mappedUser = userMapper.toEntity(customerCreateRequestDTO);
        mappedUser.setRole(Role.CUSTOMER);
        mappedUser.setAccountStatus(AccountStatus.ACTIVE);
        UserEntity savedUser = userRepository.save(mappedUser);
        return userMapper.toCustomerResponse(savedUser);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerCreateRequestDTO CustomerCreateRequestDTO, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        return null;
    }

    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {
        UserEntity response = userRepository.findById(id).orElseThrow();
        return userMapper.toEmployeeResponse(response);
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO) {
        UserEntity mappedUser = userMapper.toEntity(employeeCreateRequestDTO);
        mappedUser.setRole(Role.EMPLOYEE);
        mappedUser.setAccountStatus(AccountStatus.ACTIVE);
        UserEntity savedUser = userRepository.save(mappedUser);
        return userMapper.toEmployeeResponse(savedUser);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeCreateRequestDTO employeeCreateRequestDTO, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        return null;
    }

    @Override
    public String delete(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted";
    }

    @Override
    public Page<CustomerResponseDTO> findAllCustomers(Pageable pageable, Role role) {
        return null;
    }

    @Override
    public Page<CustomerResponseDTO> findCustomersByStatus(AccountStatus status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<EmployeeResponseDTO> findAllEmployees(Pageable pageable, Role role) {
        return null;
    }

    @Override
    public Page<EmployeeResponseDTO> findEmployeesByStatus(AccountStatus status, Pageable pageable) {
        return null;
    }
}
