package com.EmployeeManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.EmployeeManagement.Model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
