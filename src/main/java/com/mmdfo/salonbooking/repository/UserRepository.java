package com.mmdfo.salonbooking.repository;

import com.mmdfo.salonbooking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
