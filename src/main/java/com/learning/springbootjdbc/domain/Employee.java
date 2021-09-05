package com.learning.springbootjdbc.domain;

import java.math.BigDecimal;

public class Employee {

	public Employee(Integer id, String firstName, String lastName, String designation, BigDecimal salary,
			Integer managerId) {
		this.id = id;
		this.firstName = firstName;
		;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
	}

	private Integer id;
	private String firstName;
	private String lastName;
	private String designation;
	private BigDecimal salary;
	private Integer managerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder employeeDetails = new StringBuilder();
		employeeDetails.append("Id: ").append(this.id).append(" firstName: ").append(this.firstName).append(" lastName: ").append(this.lastName).
		append(" designation: ").append(this.designation).append(" salary: ").append(this.salary);
		return employeeDetails.toString();
	}

}
