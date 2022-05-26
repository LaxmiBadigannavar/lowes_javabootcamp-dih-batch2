package com.labs.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class JbdcDemo {
	
	public static void main(String[] args) {
		System.out.println("JDBC connection:");
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
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
			
			stmt=con.createStatement();
			String query="select * from Employee";
			rs=stmt.executeQuery(query);
			System.out.println(query);
			System.out.println(rs);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age = rs.getInt("age");
				String designation=rs.getString("designation");
				String department=rs.getString("department");
				String country=rs.getString("country");
				
				System.out.println("Emp id: "+id+" "+"Name: "+name
						+" age: "+age+" Designation: "+designation+" Department: "+department
						+" country: "+country);
				
				System.out.printf("%d \t %s \t %d \t %s \t %s \t %s \n", id, name, age, designation, department, country);
			}
			
		}
		catch(SQLException e){
			System.out.println("Error"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
			rs.close();
			stmt.close();
			con.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		//create statement
	}

}
