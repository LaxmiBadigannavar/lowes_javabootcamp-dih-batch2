package com.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;

public class EmployeeDaoImpl {//implements EmployeeDao {
	public void insertTable(Employee emp){

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		try {
			// STEP 2: Create Datasource instance
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setDatabaseName("jdbctraining");
			dataSource.setUser("training");
			dataSource.setPassword("training");
			dataSource.setServerName("localhost");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();


			// Insertion with Prepared Statement
			String insertQueryForPrepareStmt = "INSERT INTO employeenew (name, age,gender,designation, department,salary ) VALUES (?, ?, ?, ?, ?,?)";
			prestmt = conn.prepareStatement(insertQueryForPrepareStmt);
			prestmt.setString(1, emp.getName() );
			prestmt.setInt(2, emp.getAge());
			prestmt.setString(3, emp.getGender());
			prestmt.setString(4, emp.getDesignation());
			prestmt.setString(5, emp.getDepartment());
			prestmt.setDouble(6, emp.getSalary());
			System.out.println("Preparestatement: "+prestmt);
			int insertCount = prestmt.executeUpdate();
			prestmt.close();
			System.out.println(insertCount + " Employee(s) inserted");
			}

		 catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			
		} 
	
}
}

