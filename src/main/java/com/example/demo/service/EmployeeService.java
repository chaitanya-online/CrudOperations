package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	String addEmployee(Employee employee);
	String addEmployees(List<Employee> employee);
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployee(int id);
	String deleteEmpById(int id);
	String updateEmployee(Employee employee);
	String updateEmployeeById(Employee employee);
	List<Employee> getAllEmployeesInDesc();
	Page<Employee> findEmployeesWithPagination(int offset, int pageSize);
	

}
