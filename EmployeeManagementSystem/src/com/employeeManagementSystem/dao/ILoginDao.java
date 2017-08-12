package com.employeeManagementSystem.dao;

import java.util.List;

import com.employeeManagementSystem.domain.Employee;

public interface ILoginDao {
	
	public boolean createEmployee(Employee employee);
	
	public boolean login(Employee employee);
	
	public List<Employee> searchAllEmployee();

	public Employee searchEmployeeById(int id);

}
