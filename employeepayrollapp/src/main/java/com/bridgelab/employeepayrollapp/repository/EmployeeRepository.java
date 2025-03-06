package com.bridgelab.employeepayrollapp.repository;

import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
