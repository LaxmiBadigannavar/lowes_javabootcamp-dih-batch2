package com.empapp.dao;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConfig {
	MysqlDataSource datasource = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void getConnection() {
		datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setDatabaseName("jdbctraining");
		datasource.setUser("training");
		datasource.setPassword("training");

		try {
			conn = datasource.getConnection();
			System.out.println("Connection created successfully. " + conn);
			System.out.println("Creating statement..."); 
			  stmt =conn.createStatement(); 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
