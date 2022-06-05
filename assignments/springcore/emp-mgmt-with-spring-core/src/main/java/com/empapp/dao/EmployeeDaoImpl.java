package com.empapp.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;
	
	/*
	 * private void getConnection() { MysqlDataSource dataSource = new
	 * MysqlDataSource(); dataSource.setDatabaseName("jdbctraining");
	 * dataSource.setUser("training"); dataSource.setPassword("training");
	 * dataSource.setServerName("localhost");
	 * 
	 * 
	 * System.out.println("Connecting to database..."); try { conn =
	 * dataSource.getConnection(); System.out.println("Connection estabilished: " +
	 * conn); System.out.println("Creating statement..."); stmt =
	 * conn.createStatement(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */	
	public void insertTable(Employee emp){	
		try {
//			if(stmt==null) {
//				getConnection();
//			}
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
	public void getEmployee(int empId) {
//		if(stmt==null) {
//			getConnection();
//		}

		Employee emp = new Employee();
		String selectQuery = "SELECT * FROM employeenew where empid ="+empId;
		System.out.println("Query excuting::"+selectQuery);
		try {
			rs = stmt.executeQuery(selectQuery);
			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Gender", "Designation", "Department",
					"Salary");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("empid");
				int age = rs.getInt("age");
				String name = rs.getString("name");
			String gender = rs.getString("gender");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s \t%s\n", id, age, name,gender, designation, department, salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return emp;
	}
	public void deleteEmployee(int empid) {
//		if(stmt==null) {
//			getConnection();
//		}
		String deleteQuery = "DELETE FROM employeenew WHERE empid = ?";
		try {
			//getConnection();
			prestmt = conn.prepareStatement(deleteQuery);
			prestmt.setInt(1, empid);
			int deleteCount = prestmt.executeUpdate();
			prestmt.close();
			System.out.println(deleteCount + " Employee(s) deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateEmployee(Employee emp){
		
//		if(stmt==null) {
//			getConnection();
//		}
		try {
			System.out.println("Update is called");	
			 String updateQuery = "UPDATE employeenew SET name = ? , age = ? ,gender = ?, designation = ? , department = ?" +
	                    "  , salary = ?   WHERE empid = ?";
           
           prestmt = conn.prepareStatement(updateQuery);
			 prestmt.setString(1, emp.getName());
            prestmt.setInt(2, emp.getAge());
            prestmt.setString(3, emp.getGender());
            prestmt.setString(4, emp.getDesignation());
            prestmt.setString(5, emp.getDepartment());
            prestmt.setDouble(6, emp.getSalary());
            prestmt.setInt(7, emp.getEmpId());
            System.out.println("update query:"+prestmt);
            int updateCount = prestmt.executeUpdate();
            System.out.println(updateCount + " Employee(s) updated");
            prestmt.close();
		}catch (SQLException e) {
			System.out.println("query not updating:"+e.getMessage());
		}
	}
	public List<Employee> getAllEmployees() {
//		if(stmt==null) {
//			getConnection();
//		}
		String selectQuery = "SELECT * FROM employeenew";
		System.out.println("Query excuting::"+selectQuery);
		List<Employee> listEmp = new ArrayList<>();
		try {
			rs = stmt.executeQuery(selectQuery);
			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Gender", "Designation", "Department",
					"Salary");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("empid");
				int age = rs.getInt("age");
				String name = rs.getString("name");
			String gender = rs.getString("gender");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				
				listEmp.add(new Employee(id,name,gender,age,designation,department,salary));
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s \t%s\n", id, age, name,gender, designation, department, salary);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmp;
	}
	
	public void ImpFileToTable(Employee emp){
		
		insertTable(emp);
	}
	
	public void ExpFromTableToFile() {
//		if (stmt == null) {
//			getConnection();
//		}
		String selectQuery = "SELECT * FROM employeenew";
		System.out.println("Query excuting::" + selectQuery);
		try (FileWriter out = new FileWriter(
				"D:\\training\\lowes_javabootcamp-dih-batch2\\assignments\\corejava\\employee-mgmt-with-jdbc\\exportfile.txt")) {
		try {
			rs = stmt.executeQuery(selectQuery);
			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Name", "age", "Gender", "Designation",
					"Department", "Salary");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("empid");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				System.out.format("\t%d \t%s \t%d \t%s \t%s \t%s \t%s\n", id, name, age, gender, designation,
						department, salary);
				System.out.format("   Export started %n", Thread.currentThread().getName());
				

					String line = id + "," + name + "," + age + "," + gender + "," + designation + "," + department
							+ "," + salary + "\n";
					System.out.println("Line is"+line);
					try {
						System.out.println("Coming here:"+line);
						out.write(line);
					} catch (IOException e) {
						System.out.println("Error occured while writing employee data into file. " + e.getMessage());
						e.printStackTrace();
					}

				} 
			}catch (SQLException e) {
				e.getMessage();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

