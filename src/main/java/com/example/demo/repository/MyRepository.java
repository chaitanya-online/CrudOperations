package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface MyRepository extends JpaRepository<Employee, Integer> {
	@Query("select d from employee  d where d.domain=?1")

	public List<Employee> getEmployeeByDomain(String domain);


}
