package com.mmdfo.salonbooking.repository;

import com.mmdfo.salonbooking.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
