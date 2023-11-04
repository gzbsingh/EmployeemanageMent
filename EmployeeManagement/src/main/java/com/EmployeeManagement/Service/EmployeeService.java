package com.EmployeeManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	  private final EmployeeRepository employeeRepository;

	    @Autowired
	    public EmployeeService(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
	    public Employee createEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    // Get a list of all employees
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    // Get an employee by ID
	    public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    // Update an existing employee
	    public Employee updateEmployee(Long id, Employee updatedEmployee) {
	        if (employeeRepository.existsById(id)) {
	            updatedEmployee.setId(id);
	            return employeeRepository.save(updatedEmployee);
	        } else {
	            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
	        }
	    }

	    // Delete an employee by ID
	    public void deleteEmployee(Long id) {
	        if (employeeRepository.existsById(id)) {
	            employeeRepository.deleteById(id);
	        } else {
	            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
	        }
	    }
	
	


}
