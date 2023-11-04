package com.EmployeeManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.Model.Department;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.DepartmentRepository;
import com.EmployeeManagement.Service.DepartmentService;

@RestController
@RequestMapping("department/")
public class DepartmentController {
  @Autowired
	private DepartmentService departmentService;
	
	  @PostMapping("add/")
	    public ResponseEntity<Department> createDepartMent(@RequestBody Department department) {
		  Department createdDepartMent = departmentService.createDepartMent(department);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartMent);
	    }

	    @GetMapping
	    public ResponseEntity<List<Department>> getAllDepartments() {
	        List<Department> departments = departmentService.getAllDepartments();
	        return new ResponseEntity<>(departments, HttpStatus.OK);
	    }
	    @GetMapping("find/{id}")
	    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
	        Optional<Department> department = departmentService.getDepartmentById(id);
	        return department.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    @PutMapping("update/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department updatedDepartment) {
	        Department department = departmentService.updateDepartment(id, updatedDepartment);
	        return department != null
	                ? new ResponseEntity<>(department, HttpStatus.OK)
	                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable String id) {
	        boolean deleted = departmentService.deleteDepartment(id);
	        return deleted
	                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
	                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
}
