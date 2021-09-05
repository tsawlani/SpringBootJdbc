package com.learning.springbootjdbc;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.learning.springbootjdbc.domain.Employee;
import com.learning.springbootjdbc.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootJdbcApp implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcApp.class);

	@Autowired
	@Qualifier("employeeRepositoryImpl")
	private EmployeeRepository employeeRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		setupJdbc();

	}

	public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApp.class, args);
    }
	
	private void setupJdbc() {
		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE Employees IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE Employees("
				+ "id Numeric(12,0), firstName VARCHAR(255), lastName varchar(255), designation varchar(255), salary NUMERIC(15, 2), managerId Numeric(12,0))");

		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Test1", "Kumar", "QA Enigneer", new BigDecimal("600000.00"), 101),
				new Employee(2, "Test2", "Kumar", "QA Enigneer Lead", new BigDecimal("1200000.00"), 101),
				new Employee(3, "Dev1", "Kumar", "Software Enigneer", new BigDecimal("600000.00"), 102),
				new Employee(4, "Dev2", "Kumar", "Tech Lead", new BigDecimal("1200000.00"), 102),
				new Employee(101, "TestManager", "Kumar", "QA Manager", new BigDecimal("1800000.00"), 0),
				new Employee(102, "DevManager", "Kumar", "Dev Manager", new BigDecimal("2000000.00"), 0));

		employeeList.forEach(employee -> {
			log.info("Saving Employee : {}", employee.getId());
			employeeRepository.saveEmployee(employee);
		});
		
		
		log.info("Total Employee Count: {} ", employeeRepository.count());
		
		log.info("All Employees: {}", employeeRepository.findAll());
		
	}

}
