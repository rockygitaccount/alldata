package com.SB_CRUD_Program1.service;

import java.util.List;

import com.SB_CRUD_Program1.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(long id);

}
