package com.EmployeeManagement.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Service.EmployeeService;

@RestController
@RequestMapping("employee/")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	  @PostMapping("add/")
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee createdEmployee = employeeService.createEmployee(employee);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	    }
	 @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	  @GetMapping("find/{employeeId}")
	    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long employeeId) {
	        try {
	            Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
	            return ResponseEntity.ok(employee);
	        } catch (EmployeeNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("update/{employeeId}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
	        try {
	            Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
	            return ResponseEntity.ok(updatedEmployee);
	        } catch (EmployeeNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("delete/{employeeId}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
	        try {
	            employeeService.deleteEmployee(employeeId);
	            return ResponseEntity.noContent().build();
	        } catch (EmployeeNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
