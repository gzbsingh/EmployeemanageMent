package com.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagement.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
