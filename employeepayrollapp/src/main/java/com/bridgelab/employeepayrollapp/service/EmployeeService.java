package com.bridgelab.employeepayrollapp.service;

import com.bridgelab.employeepayrollapp.model.Employee;
import com.bridgelab.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add new employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        ;
        return employeeRepository.findById(id);
    }


    // Update employee
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(existingEmployee);
        });
    }

    // Delete employee
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
