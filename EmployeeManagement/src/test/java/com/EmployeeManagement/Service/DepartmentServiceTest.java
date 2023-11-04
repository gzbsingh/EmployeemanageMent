package com.EmployeeManagement.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.EmployeeManagement.Model.Department;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.DepartmentRepository;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

//	@Test
//	void testDepartmentService() {
//		fail("Not yet implemented");
//	}
//
	@InjectMocks
	private DepartmentService departmentService;
	@Mock
	private DepartmentRepository departmentRepository;
	
	@Test
	void testCreateDepartMent() {
	Department d1=new Department();
	d1.setDepartmentId("2");
	d1.setDepartmentName("HR");
	Mockito.when(departmentRepository.save(Mockito.any(Department.class))).thenReturn(d1);
	//Actual 
	Department result= departmentService.createDepartMent(d1);
	assertNotNull(result);
	assertEquals("2", result.getDepartmentId());
	assertEquals("HR",result.getDepartmentName());
	
	}

	@Test
	void testGetAllDepartments() {
		Department d1=new Department();
		d1.setDepartmentId("2");
		d1.setDepartmentName("HR");
		 List<Department> departments = List.of(d1);
		    Mockito.when(departmentRepository.findAll()).thenReturn(departments);
		    //Actual
		    List<Department> result = departmentService.getAllDepartments();
		    assertNotNull(result);
		    assertEquals(1, result.size()); 
	}

	@Test
	void testGetDepartmentById() {
		Department d1=new Department();
		d1.setDepartmentId("2");
		d1.setDepartmentName("HR");
		  Mockito.when(departmentRepository.findById(d1.getDepartmentId())).thenReturn(Optional.of(d1));
		  
		  //Act
		    Optional<Department> result=departmentService.getDepartmentById(d1.getDepartmentId());
		  assertTrue(result.isPresent());
		  assertEquals(d1.getDepartmentId(), result.get().getDepartmentId());
	}

	

}
