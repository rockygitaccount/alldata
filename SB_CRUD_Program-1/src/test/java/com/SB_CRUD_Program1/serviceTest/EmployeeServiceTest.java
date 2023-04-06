package com.SB_CRUD_Program1.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.SB_CRUD_Program1.entity.Employee;
import com.SB_CRUD_Program1.repository.EmployeeRepository;
import com.SB_CRUD_Program1.serviceImpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

		@InjectMocks
		private EmployeeServiceImpl employeeService;

		@Mock
		private EmployeeRepository employeeRepository;

		@Test
		public void testGetAllEmployees() {
			List<Employee> employeeList = new ArrayList<Employee>();
	        Employee employee1 = new Employee(1L, "John", "john@example.com", 30, 50000L);
	        Employee employee2 = new Employee(2L, "Jane", "jane@example.com", 25, 40000L);
	        employeeList.add(employee1);
	        employeeList.add(employee2);

	        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);

	        List<Employee> result = employeeService.getAllEmployees();

	        assertThat(result.size()).isEqualTo(2);
	        assertThat(result.get(0).getName()).isEqualTo("John");
	        assertThat(result.get(1).getName()).isEqualTo("Jane");
	    }

		@Test
		public void testGetEmployeeById() {
			Employee employee = new Employee(1L, "John", "john@example.com", 25, 50000);

			org.mockito.Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

			Employee result = employeeService.getEmployeeById(1L);

			assertNotNull(result);
			assertEquals(1L, result.getId());
			assertEquals("John", result.getName());
			assertEquals("john@example.com", result.getEmail());
			assertEquals(25, result.getAge());
			assertEquals(50000, result.getSalary());
		}

		@Test
		public void testAddEmployee() {
			Employee employee = new Employee(1L, "John", "john@example.com", 25, 50000);

			org.mockito.Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

			Employee result = employeeService.addEmployee(employee);

			assertNotNull(result);
			assertEquals(1L, result.getId());
			assertEquals("John", result.getName());
			assertEquals("john@example.com", result.getEmail());
			assertEquals(25, result.getAge());
			assertEquals(50000, result.getSalary());
		}

		  @Test
		    public void testUpdateEmployee() {
		        List<Employee> employees = employeeService.getAllEmployees();
		        if (!employees.isEmpty()) {
		            Employee employee = employees.get(0);
		            employee.setName("Bob Johnson");
		            employee.setEmail("bob.johnson@example.com");
		            employee.setAge(30);
		            employee.setSalary(80000L);
		            employeeService.updateEmployee(employee);
		            Employee updatedEmployee = employeeService.getEmployeeById(employee.getId());
		            assertEquals("Bob Johnson", updatedEmployee.getName());
		            assertEquals("bob.johnson@example.com", updatedEmployee.getEmail());
		            assertEquals(30, updatedEmployee.getAge());
		            assertEquals(80000L, updatedEmployee.getSalary());
		        }
		    }

		    @Test
		    public void testDeleteEmployee() {
		        List<Employee> employees = employeeService.getAllEmployees();
		        if (!employees.isEmpty()) {
		            Employee employee = employees.get(0);
		            long employeeId = employee.getId();
		            employeeService.deleteEmployee(employeeId);
		            Employee deletedEmployee = employeeService.getEmployeeById(employeeId);
		            assertNull(deletedEmployee);
		        }
		    }
}

