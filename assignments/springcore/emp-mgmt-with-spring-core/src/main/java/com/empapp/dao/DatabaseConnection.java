package com.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;
	 
	  private void getConnection() {
		  MysqlDataSource dataSource = new MysqlDataSource(); 
		  dataSource.setDatabaseName("jdbctraining");
		  dataSource.setUser("training"); dataSource.setPassword("training");
		  dataSource.setServerName("localhost");
	  
	  
	  System.out.println("Connecting to database..."); 
	  try { conn =dataSource.getConnection();
	  System.out.println("Connection estabilished: " + conn); 
	  System.out.println("Creating statement..."); 
	  stmt =conn.createStatement(); 
	  } catch (SQLException e) { // TODO Auto-generated
		  e.printStackTrace(); }
	  
	 }
}
