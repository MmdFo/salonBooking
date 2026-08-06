package com.mmdfo.salonbooking.service;


import com.mmdfo.salonbooking.repository.AdminRepository;
import com.mmdfo.salonbooking.repository.CustomerRepository;
import com.mmdfo.salonbooking.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public
}
