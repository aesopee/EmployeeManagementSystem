package com.employeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employeeManagementSystem.domain.Employee;

public class LoginDaoImpl {
	private Connection con;

	public LoginDaoImpl() {
		getConnection();
	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/EmployeeManagementSystemForSwing",
							"root", "");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}

	public synchronized boolean createEmployee(Employee employee) {

		// System.out.println(employee);
		// String insertQuery =
		// "insert into Employee(employeeFirstName, employeeMiddleName, employeeLastName, employeeUserName, employeePassword, securityQuestion, securityAnswer)"
		// + " values(?,?,?,?,?,?,?)";
		// String employeeUserName = createEmployeeUserName(employee);
		//
		// //this.jdbcTemplate.update(insertQuery,"a","a","a","a","a","a","a");
		// this.jdbcTemplate.update(insertQuery,
		// employee.getEmployeeFirstName(),
		// employee.getEmployeeMiddleName(),
		// employee.getEmployeeLastName(), employeeUserName,
		// employee.getEmployeePassword(), employee.getSecurityQuestion(),
		// employee.getSecurityAnswer());

		try {
			String userName = createEmployeeUserName(employee);
			String sql = "insert into Employee(employeeFirstName, employeeMiddleName, employeeLastName, employeeUserName, employeePassword, securityQuestion, securityAnswer)"
					+ " values(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getMiddleName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, userName);
			ps.setString(5, employee.getPassword());
			ps.setString(6, employee.getSecurityQuestion());
			ps.setString(7, employee.getSecurityAnswer());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	public boolean login(Employee employee) {

		return false;
	}

	private String createEmployeeUserName(Employee employee) {
		String employeeUserName = null;
		int count = 0;
		try {

			String selectQuery = "SELECT employeeFirstName, employeeMiddleName, employeeLastName, employeeId, employeePassword, employeeUserName, securityQuestion, securityAnswer FROM employee "
				+ " WHERE employeeFirstName = ? AND employeeLastName = ?";
			
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());

			ResultSet rs = ps.executeQuery(selectQuery);
			
			while (rs.next()) {
				count = count + 1;
			}
			if (count != 0) {
				employeeUserName = employee.getFirstName() + "."
						+ employee.getLastName();
			} else {
				employeeUserName = employee.getFirstName() + "."
						+ employee.getLastName() + count;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return employeeUserName;
	}

	

	public List<Employee> searchAllEmployee() {

		List<Employee> employeeList = null;
		try {
			String selectQuery = "SELECT employeeFirstName, employeeId, employeeLastName,employeeMiddleName,employeePassword, employeeUserName "
					+ " FROM employee";

			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(selectQuery);
			employeeList = new ArrayList<Employee>();

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString("employeeFirstName"));
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setLastName(rs.getString("employeeLastName"));
				employee.setMiddleName(rs
						.getString("employeeMiddleName"));
				employee.setPassword(rs.getString("employeePassword"));
				employee.setUserName(rs.getString("employeeUserName"));
				employeeList.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return employeeList;
	}

}
