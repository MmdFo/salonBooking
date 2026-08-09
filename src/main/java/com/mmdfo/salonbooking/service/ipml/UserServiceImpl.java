package com.mmdfo.salonbooking.service.ipml;

import com.mmdfo.salonbooking.dto.CustomerCreateRequestDTO;
import com.mmdfo.salonbooking.dto.CustomerResponseDTO;
import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.EmployeeSalonServiceStatus;
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

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public CustomerResponseDTO findById(Long id) {
        UserEntity response = userRepository.findById(id).orElseThrow();
        return userMapper.toCustomerResponse(response);
    }

    @Override
    public CustomerResponseDTO create(CustomerCreateRequestDTO customerCreateRequestDTO) {
        UserEntity mappedUser =  userRepository.save(userMapper.toEntity(customerCreateRequestDTO));
        mappedUser.setRole(Role.CUSTOMER);
        return userMapper.toCustomerResponse(mappedUser);
    }

    @Override
    public CustomerResponseDTO update(CustomerCreateRequestDTO CustomerCreateRequestDTO, Long id) {
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
    public Page<CustomerResponseDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CustomerResponseDTO> findByStatus(EmployeeSalonServiceStatus status, Pageable pageable) {
        return null;
    }
}
