package com.learning.springbootjdbc.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.springbootjdbc.domain.Employee;
import com.learning.springbootjdbc.repository.EmployeeRepository;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Value("${employee.save}")
	private String saveEmployeeQuery;

	@Value("${employee.save}")
	private String updatupdateeEmployeeQuery;

	@Value("${employee.delete}")
	private String deleteEmployeeQuery;

	@Value("${employee.count}")
	private String countEmployeeQuery;

	@Value("${employee.findAll}")
	private String findAllEmployeeQuery;

	@Value("${employee.findById}")
	private String findEmployeeByIdQuery;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee employee) {
		return jdbcTemplate.update(saveEmployeeQuery, employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getDesignation(), employee.getSalary(), employee.getManagerId());
	}

	public int updateEmployee(Employee employee) {
		return jdbcTemplate.update(updatupdateeEmployeeQuery, employee.getFirstName(), employee.getLastName(),
				employee.getDesignation(), employee.getSalary(), employee.getManagerId(), employee.getId());
	}

	public int deleteEmployee(Integer id) {
		return jdbcTemplate.update(deleteEmployeeQuery, id);
	}

	public int count() {
		return jdbcTemplate.queryForObject(countEmployeeQuery, Integer.class);
	}

	public List<Employee> findAll() {
		return jdbcTemplate.query(findAllEmployeeQuery, (rs,rowNum) -> new Employee(rs.getInt("id"), rs.getString("firstName"), 
							rs.getString("lastName"), rs.getString("designation"),rs.getBigDecimal("salary"), rs.getInt("managerId")));
	}

	public Optional<Employee> findEmployeeById(Integer id) {
		return jdbcTemplate.queryForObject(findEmployeeByIdQuery,new Object[]{id}, (rs,rowNum) -> Optional.of(new Employee(rs.getInt("id"), rs.getString("firstName"), 
				rs.getString("lastName"), rs.getString("designation"),rs.getBigDecimal("salary"), rs.getInt("managerId"))));
	}

}
