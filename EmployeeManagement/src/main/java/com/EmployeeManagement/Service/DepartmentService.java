package com.EmployeeManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.Exception.DepartMentNotFoundException;
import com.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.EmployeeManagement.Model.Department;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.DepartmentRepository;
@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
	public Department createDepartMent(Department department) {
		// TODO Auto-generated method stub
		 return departmentRepository.save(department);
	}
	   public List<Department> getAllDepartments() {
	        return departmentRepository.findAll();
	    }
	   public Optional<Department> getDepartmentById(String id) {
	        return Optional.of(departmentRepository.findById(id).orElseThrow(()-> new DepartMentNotFoundException(id+"not found")));
	    }
	   public Department updateDepartment(String id, Department updatedDepartment) {
	        if(departmentRepository.existsById(id)) {
	        	return departmentRepository.save(updatedDepartment);
	        }
	        else {
	        	 throw new DepartMentNotFoundException("DepartMent with ID " + id + " not found");
	        }
	    }
	   public boolean deleteDepartment(String id) {
		   if(departmentRepository.existsById(id)) {
	        	 departmentRepository.deleteById(id);
	        	 return true;
	        }
		   return false;
	   }
}
