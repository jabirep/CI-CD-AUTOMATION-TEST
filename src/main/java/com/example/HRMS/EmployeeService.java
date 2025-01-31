package com.example.HRMS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//need to import employee class and repository class
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        if (employeeRepository.existsById(id)) {
            employeeDetails.setId(id);
            return employeeRepository.save(employeeDetails);
        }
        return null;
    }

    public Employee updateEmployees(Long id, Employee employeeDetails) {
        if (employeeRepository.existsById(id)) {
            employeeDetails.setId(id);
            return employeeRepository.save(employeeDetails);
        }
        return null;
    }
}
