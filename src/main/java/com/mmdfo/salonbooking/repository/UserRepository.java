package com.mmdfo.salonbooking.repository;

import com.mmdfo.salonbooking.entity.UserEntity;
import com.mmdfo.salonbooking.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdAndRole(Long id, Role role);

    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
