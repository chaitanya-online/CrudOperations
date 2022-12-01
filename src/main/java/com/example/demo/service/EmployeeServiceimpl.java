package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;


@Service
@CacheConfig(cacheNames = {"Employee"})
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	MyRepository reposiroty;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			reposiroty.save(employee);
			return "employee added";

		} catch (Exception e) {
			return "Allready exists";
		}
	}

	@Override
	public String addEmployees(List<Employee> employee) {
		// TODO Auto-generated method stub
		reposiroty.saveAll(employee);
		return "employees added " + employee;

	}

	@Override
	@Cacheable(cacheNames = "Employee")
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return reposiroty.findAll();
	}

	@Override
	@Cacheable(cacheNames = "Employee")
	public Optional<Employee> getEmployee(int id) {
		// TODO Auto-generated method stub
		return reposiroty.findById(id);
	}

	@Override
	public String deleteEmpById(int id) {
		// TODO Auto-generated method stub
		reposiroty.deleteById(id);
		return "Employee deleted" + id;
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stubs

		try {
			reposiroty.save(employee);
			return "Updated";

		} catch (Exception e) {
			return "Name must be unique";
		}

	}

	@Override
	public String updateEmployeeById(Employee employee) {
		// TODO Auto-generated method stub
		reposiroty.save(employee);
		return "Employee updated" ;
	}

	@Override
	@Cacheable(cacheNames = "Employee")
	public List<Employee> getAllEmployeesInDesc() {
		// TODO Auto-generated method stub
	return	reposiroty.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}

	@Override
	public Page<Employee> findEmployeesWithPagination(int offset, int pageSize) {
		// TODO Auto-generated method stub
		Page<Employee> employees = reposiroty.findAll(PageRequest.of(offset,pageSize));
		return employees;
	}
	
	public List<Employee>getEmployeeByDomain(String domain)
	{
		return reposiroty.getEmployeeByDomain(domain);
	}
	
	
	
	
}
