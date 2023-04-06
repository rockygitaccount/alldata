package com.SB_CRUD_Program1.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.SB_CRUD_Program1.controller.EmployeeController;
import com.SB_CRUD_Program1.entity.Employee;
import com.SB_CRUD_Program1.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private List<Employee> employeeList;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employeeList = new ArrayList<>();
        employee = new Employee(1L, "John", "john@example.com", 25, 5000L);
        employeeList.add(employee);
    }

    @Test
    void testGetAllEmployees() {
        doReturn(employeeList).when(employeeService).getAllEmployees();

        ResponseEntity<List<Employee>> responseEntity = employeeController.getAllEmployees();

        verify(employeeService).getAllEmployees();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(employeeList);
    }
    
   

    @Test
    void testGetEmployeeById() {
        long id = 1L;
        doReturn(employee).when(employeeService).getEmployeeById(id);

        ResponseEntity<Employee> responseEntity = employeeController.getEmployeeById(id);

        verify(employeeService).getEmployeeById(id);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(employee);
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        long id = 2L;

        doReturn(null).when(employeeService).getEmployeeById(id);

        ResponseEntity<Employee> responseEntity = employeeController.getEmployeeById(id);

        verify(employeeService).getEmployeeById(id);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
    
    @Test
    void testAddEmployee() {
        doReturn(employee).when(employeeService).addEmployee(ArgumentMatchers.any(Employee.class));

        ResponseEntity<Employee> responseEntity = employeeController.addEmployee(employee);

        verify(employeeService).addEmployee(employee);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isEqualTo(employee);
    }
    
    @Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("John Doe");
		employee.setSalary(5000);

		doReturn(employee).when(employeeService).updateEmployee(employee);

		ResponseEntity<Employee> response = employeeController.updateEmployee(1L, employee);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1L, response.getBody().getId());
		assertEquals("John Doe", response.getBody().getName());
		assertEquals(5000, response.getBody().getSalary());
	}
    
    @Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("John Doe");
		employee.setSalary(5000);

		doNothing().when(employeeService).deleteEmployee(1L);

		ResponseEntity<Void> response = employeeController.deleteEmployee(1L);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
}
