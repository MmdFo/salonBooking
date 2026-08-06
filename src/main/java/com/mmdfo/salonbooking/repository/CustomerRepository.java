package com.mmdfo.salonbooking.repository;

import com.mmdfo.salonbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFullNameContainingIgnoreCase(String fullName);
    Optional<Customer> findByEmailIgnoreCase(String email);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
    boolean existsByEmailContainingIgnoreCase(String email);
    boolean existsByPhoneNumber(String phoneNumber);

}