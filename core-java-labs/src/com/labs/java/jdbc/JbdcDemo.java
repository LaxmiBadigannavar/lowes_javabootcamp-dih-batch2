package com.labs.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class JbdcDemo {
	
	public static void main(String[] args) {
		System.out.println("JDBC connection:");
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement PreStatement =null;
		//load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		}
		catch(ClassNotFoundException e){
			System.out.println("Error"+e.getMessage());
		}
		//open connection to DB
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining","training","training");
			System.out.println(con);
			System.out.println("connection successfull");
			
			//String PreStatement;
			//Insertion with Prepared Statement
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			PreStatement = con.prepareStatement(insertQueryForPrepareStmt);
			PreStatement.setString(1, "Mathew");
			PreStatement.setInt(2, 30);
			PreStatement.setString(3, "Lead");
			PreStatement.setString(4, "IT");
			PreStatement.setString(5, "India");
			int insertCount = PreStatement.executeUpdate();
			PreStatement.close();
			System.out.println(insertCount + " Employee(s) inserted");
			
		}
		catch(SQLException e){
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
			//rs.close();
			stmt.close();
			con.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		//create statement
	}

}
