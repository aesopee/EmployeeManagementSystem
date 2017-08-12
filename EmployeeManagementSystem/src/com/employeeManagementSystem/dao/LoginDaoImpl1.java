package com.employeeManagementSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.employeeManagementSystem.domain.Employee;

public class LoginDaoImpl1 implements ILoginDao{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean createEmployee(Employee employee) {

		String insertQuery = "insert into Employee(firstName, middleName, lastName, userName, password, securityQuestion, securityAnswer)" +
													" values(?,?,?,?,?,?,?)";
		String employeeUserName = createEmployeeUserName(employee);

		this.jdbcTemplate.update(insertQuery,
				employee.getFirstName(),
				employee.getMiddleName(),
				employee.getLastName(), employeeUserName,
				employee.getPassword(), employee.getSecurityQuestion(),
				employee.getSecurityAnswer());

		return false;
	}

	private String createEmployeeUserName(Employee employee) {

		String employeeUserName = null;
		List<Employee> employeeList = new ArrayList<Employee>();

		String selectQuery = "SELECT employeeId, firstName , middleName, lastName, userName, PASSWORD, securityQuestion, securityAnswer " +
													" FROM employee where firstName = ? AND lastName= ?";
		employeeList = jdbcTemplate.query(selectQuery, new Object[] { employee.getFirstName(), employee.getLastName() },new EmployeeRowMapper());

		if (employeeList.size() == 0) {
			employeeUserName = employee.getFirstName() + "."
			+ employee.getLastName();
		} else {
			employeeUserName = employee.getFirstName() + "."
			+ employee.getLastName() + employeeList.size();
		}

		return employeeUserName;
	}
	
	@Override
	public boolean login(Employee employee) {
		return false;
	}
	
	@Override
	public List<Employee> searchAllEmployee() {

		List<Employee> employeeList = new ArrayList<Employee>();

		String selectQuery = "SELECT employeeId, firstName , middleName, lastName, userName, PASSWORD, securityQuestion, securityAnswer " +
													" FROM employee";
		employeeList = jdbcTemplate.query(selectQuery, new EmployeeRowMapper());
		return employeeList;
	}

	private static final class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet resultSet, int rowNum)
		throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeId(resultSet.getInt("employeeId"));
			employee.setFirstName(resultSet.getString("firstName"));
			employee.setMiddleName(resultSet.getString("middleName"));
			employee.setLastName(resultSet.getString("lastName"));
			employee.setUserName(resultSet.getString("userName"));
			employee.setSecurityQuestion(resultSet.getString("securityQuestion"));
			employee.setPassword(resultSet.getString("password"));
			employee.setSecurityAnswer(resultSet.getString("securityAnswer"));
			return employee;
		}
	}

	@Override
	public Employee searchEmployeeById(int id) {
		String selectQuery = "SELECT employeeId, firstName , middleName, lastName, userName, PASSWORD, securityQuestion, securityAnswer " +
													" FROM employee where employeeId = ?";
		Employee employee =  jdbcTemplate.queryForObject(selectQuery, new Object[] { id },new EmployeeRowMapper());
		return employee;
	}
}
