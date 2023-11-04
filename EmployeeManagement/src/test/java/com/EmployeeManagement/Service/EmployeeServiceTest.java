package com.EmployeeManagement.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.EmployeeRepository;
@ExtendWith(MockitoExtension.class)

class EmployeeServiceTest {
	@InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

//	@Test
//	void testEmployeeService() {
//		fail("Not yet implemented");
//	}
//
//	
	
    @Test
    void testCreateEmployee() {
        // Arrange
        Employee e1 = new Employee();
        e1.setFirstName("John");
        e1.setLastName("Doe");
        
        
        Employee c2 = new Employee();
        c2.setId(1L);
        c2.setFirstName("John");
        c2.setLastName("Doe");
        // Set other properties as needed

        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(c2);
        // Act
        Employee result = employeeService.createEmployee(c2);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId()); // Ensure the ID is set after creation
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        // Add more assertions for other properties

        Mockito.verify(employeeRepository).save(Mockito.any(Employee.class)); // Verify that save was called
    }

	@Test
	void testGetAllEmployees() {
		 Employee e1 = new Employee();
	        e1.setFirstName("John");
	        e1.setLastName("Doe");
	        
	        
	        Employee c2 = new Employee();
	        c2.setId(1L);
	        c2.setFirstName("John");
	        c2.setLastName("Doe");
		 List<Employee> employees = List.of(e1,c2);
			    
			    // Mock the repository behavior
			    Mockito.when(employeeRepository.findAll()).thenReturn(employees);
			    
			    // Act
			    List<Employee> result = employeeService.getAllEmployees();

			    // Assert
			    assertNotNull(result);
			    assertEquals(2, result.size()); 
	}

	@Test
	void testGetEmployeeById() {
		  Long employeeId = 1L;
		    Employee employee = new Employee();
		    employee.setId(employeeId);
		    employee.setFirstName("John");
		    employee.setLastName("Doe");
		    
		    Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
		    
		    //Act
		    Optional<Employee> result=employeeService.getEmployeeById(employeeId);
		  
		    assertTrue(result.isPresent());
		    assertEquals(employeeId, result.get().getId());
		    assertEquals("John", result.get().getFirstName());
		    assertEquals("Doe", result.get().getLastName());
		    Mockito.verify(employeeRepository).findById(employeeId);
	}


}
