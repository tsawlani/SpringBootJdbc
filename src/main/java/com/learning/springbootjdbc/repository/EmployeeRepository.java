package com.learning.springbootjdbc.repository;

import java.util.List;
import java.util.Optional;

import com.learning.springbootjdbc.domain.Employee;

public interface EmployeeRepository {
	
	public int saveEmployee(Employee employee);
	
	public int updateEmployee(Employee employee);
	
	public int deleteEmployee(Integer id);
	
	public int count();
	
	public List<Employee> findAll();
	
	public Optional<Employee> findEmployeeById(Integer Id);
	
}
